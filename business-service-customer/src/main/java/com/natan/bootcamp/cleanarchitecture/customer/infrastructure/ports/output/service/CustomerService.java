package com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Customer;
import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Risk;
import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Status;
import com.natan.bootcamp.cleanarchitecture.customer.domain.exceptions.CustomerManagementException;
import com.natan.bootcamp.cleanarchitecture.customer.domain.ports.output.ICustomerOutputPort;
import com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.model.CustomerModel;
import com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.modelmapping.CustomerModelMapping;
import com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.repository.ICustomerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerOutputPort {
	
	@Autowired
	private ICustomerCrudRepository customerRepository;
	@Override
	public Customer saveClient(Customer customer) throws CustomerManagementException {

		CustomerModel mappedCustomerModel = CustomerModelMapping
				.mapCustomerEntityToCustomerModel(customer);
		
		//if client already exists
		if (customerRepository.findById(mappedCustomerModel.getId()).isPresent()){
			
			throw new CustomerManagementException("error: client already exists");
		}
		
		//else save it
		CustomerModel customerModel = customerRepository.save(mappedCustomerModel);
		customer.setId(customerModel.getId());
		return customer;
	}

	@Override
	public Optional<Customer> findByCustomerId(String customerId) throws CustomerManagementException {
	
		//if not exists
		CustomerModel customerModel = customerRepository.findById(customerId).orElseThrow(
				() -> new CustomerManagementException("error: customer id <"+customerId+"> not found"));
		
		//else
		Optional<Customer> customer = Optional.of(CustomerModelMapping
				.mapCustomerModelToCustomerEntity(customerModel)
		);
		customer.get().setId(customerModel.getId());

		return customer;
	}

	@Override
	public List<Customer> findByCustomerLastname(String clientLastname) throws CustomerManagementException {
		
		List<CustomerModel> listCustomersModel = customerRepository.findByLastname(clientLastname);
		
		if(listCustomersModel.isEmpty()) {
			throw new CustomerManagementException("error: the client "+clientLastname+" not found");
		}
		
		List<Customer> listCustomers = new ArrayList<Customer>();
		listCustomersModel.forEach(customerModel ->{
			Customer customer = CustomerModelMapping.mapCustomerModelToCustomerEntity(customerModel);
			customer.setId(customerModel.getId()); //for not to modify registered customerId
			listCustomers.add(customer);
		});
		
		return listCustomers;
	}

	@Override
	public List<Customer> findByCustomerRisk(String risk) {
			
		List<CustomerModel> listCustomersModel = customerRepository.findByRisk(risk);
		
		List<Customer> listCustomers = new ArrayList<Customer>();
		listCustomersModel.forEach(customerModel ->{
			Customer customer = CustomerModelMapping.mapCustomerModelToCustomerEntity(customerModel);
			customer.setId(customerModel.getId());//for not to modify registered customerId
			listCustomers.add(customer);
		});
		
		return listCustomers;
	}

	@Override
	public List<Customer> findByCustomerStatus(String status) {
		
		List<CustomerModel> listCustomersModel = customerRepository.findByStatus(status);
		
		List<Customer> listCustomers = new ArrayList<Customer>();
		listCustomersModel.forEach(customerModel ->{
			Customer customer = CustomerModelMapping.mapCustomerModelToCustomerEntity(customerModel);
			customer.setId(customerModel.getId());
			listCustomers.add(customer);
		});
		
		return listCustomers;
	}
	

	@Override
	public List<Customer> findAllCustomers() {
		
		List<CustomerModel> listCustomersModel = customerRepository.findAll();
		List<Customer> listCustomer = new ArrayList<Customer>();
		listCustomersModel.forEach(customerModel ->{
			Customer customer = CustomerModelMapping.mapCustomerModelToCustomerEntity(customerModel);
			customer.setId(customerModel.getId());
			listCustomer.add(customer);
		});
		
		return listCustomer;
	}
	
	@Transactional
	@Override
	public Optional<Customer> updateCustomerRisk(String customerId, String risk)
			throws CustomerManagementException {
	
		risk = risk.strip().toUpperCase();
		
		Optional<CustomerModel> customerModel = Optional.ofNullable(customerRepository.findById(customerId)
				.orElseThrow( ()-> new CustomerManagementException("error: customer not found")));
		//else
		if(customerModel.get().getRisk().equals(risk)) {
			throw new CustomerManagementException("error: you have entered the same risk <"+risk+">");
		}
		
		else if (risk.isEmpty() ||(! risk.equals(Risk.FAIBLE) && ! risk.equals(Risk.IMPORTANT))) {
			
			throw new CustomerManagementException("error: choose "+ Risk.FAIBLE+" or "+Risk.IMPORTANT);
		}
		
		customerModel.get().setRisk(Risk.valueOf(risk));
		Optional<Customer> customer  = customerModel.map(CustomerModelMapping::mapCustomerModelToCustomerEntity);
		customer.get().setId(customerModel.get().getId());
		return customer;
	}

	@Transactional
	@Override
	public Optional<Customer> updateCustomerStatus(String customerId, String status)
			throws CustomerManagementException {
		
		status = status.toUpperCase();
		
		Optional<CustomerModel> customerModel = Optional.ofNullable(customerRepository.findById(customerId)
				.orElseThrow( ()-> new CustomerManagementException("error: customer not found")));
		//else
		if(customerModel.get().getRisk().equals(status)) {
			throw new CustomerManagementException("error: entered the same status <"+status+"> ");
		}
		else if (! status.equals(Status.ACTIF) && ! status.equals(Status.HISTORISE)) {
			
			throw new CustomerManagementException("error: choose "+ Status.ACTIF+" or "+Status.HISTORISE);
		}
		
		customerModel.get().setStatus(Status.valueOf(status));
		Optional<Customer> customer  = customerModel.map(CustomerModelMapping::mapCustomerModelToCustomerEntity);
		customer.get().setId(customerModel.get().getId());
		return customer;
	}

	@Override @Transactional
	public Optional<Customer> updateCustomerLastname(String customerId, String lastname)
			throws CustomerManagementException {
		
		Optional<CustomerModel> customerModel = Optional.ofNullable(customerRepository.findById(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
						));
		//else
		if(customerModel.get().getLastname().equals(lastname)) {
			
			throw new CustomerManagementException("error: entered the same lastname");
		}
		
		customerModel.get().setLastname(lastname);
		
		Optional<Customer> customer  = customerModel.map(CustomerModelMapping::mapCustomerModelToCustomerEntity);
		customer.get().setId(customerModel.get().getId());
		return customer;
		
	}

	@Override @Transactional
	public Optional<Customer> updateCustomerFirstname(String customerId, String firstname)
			throws CustomerManagementException {

		Optional<CustomerModel> customerModel = Optional.ofNullable(customerRepository.findById(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
						));
		//else
		if(customerModel.get().getFirstname().equals(firstname)) {
			
			throw new CustomerManagementException("error: entered the same firstname");
		}
		
		customerModel.get().setFirstname(firstname);
		
		Optional<Customer> customer  = customerModel.map(CustomerModelMapping::mapCustomerModelToCustomerEntity);
		customer.get().setId(customerModel.get().getId());

		return customer;
	}

}
