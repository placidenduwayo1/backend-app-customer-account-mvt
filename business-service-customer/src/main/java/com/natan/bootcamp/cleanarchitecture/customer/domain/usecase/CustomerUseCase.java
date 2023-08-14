package com.natan.bootcamp.cleanarchitecture.customer.domain.usecase;

import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Customer;
import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Risk;
import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Status;
import com.natan.bootcamp.cleanarchitecture.customer.domain.dto.CustomerDto;
import com.natan.bootcamp.cleanarchitecture.customer.domain.mapping.CustomerEntityMapping;
import com.natan.bootcamp.cleanarchitecture.customer.domain.exceptions.CustomerManagementException;
import com.natan.bootcamp.cleanarchitecture.customer.domain.ports.input.ICustomerInputPort;
import com.natan.bootcamp.cleanarchitecture.customer.domain.ports.output.ICustomerOutputPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerUseCase implements ICustomerInputPort {

	private final ICustomerOutputPort clientOutputPort;
	
	public CustomerUseCase(ICustomerOutputPort clientOutputPort) {
		super();
		this.clientOutputPort = clientOutputPort;
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) throws CustomerManagementException {

		customerDto = customerNormalization1(customerDto);

		if(customerDto.getLastname().isEmpty() || customerDto.getFirstname().isEmpty()) {
			throw new CustomerManagementException("error: all fields are mandatory");
		}
		if(! customerDto.getRisk().equals(Risk.FAIBLE)  && ! customerDto.getRisk().equals(Risk.IMPORTANT)) {

			throw new CustomerManagementException("error: possible values for risk:"+Risk.FAIBLE+"or "+Risk.IMPORTANT);
		}
		if(! customerDto.getStatus().equals(Status.ACTIF)
						&& ! customerDto.getStatus().equals(Status.HISTORISE)) {

			throw new CustomerManagementException("error: possible values for status:"+Status.ACTIF+" or "+Status.HISTORISE);
		}
		Customer customer = CustomerEntityMapping.mapClientDtoToClientEntity(customerDto);
		clientOutputPort.saveClient(customer);
		customerDto.setId(customer.getId());

		return customerDto;
	}

	@Override
	public Optional<CustomerDto> getByCustomerId(String customerId) throws CustomerManagementException {

		customerId = customerNormalization2(customerId);
		if(customerId.isEmpty()) {

			throw new CustomerManagementException("error: input customer id");
		}

		Optional<Customer> customer = Optional.of(clientOutputPort.findByCustomerId(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
				)
		);

		Optional<CustomerDto> customerDto  = customer.map(CustomerEntityMapping::mapClientEntityToClientDto);
		customerDto.get().setId(customer.get().getId());

		return customerDto;
	}

	@Override
	public List<CustomerDto> getByCustomerLastname(String customerLastname) throws CustomerManagementException {

		customerLastname = customerNormalization2(customerLastname);

		if(customerLastname.isEmpty()) {
			throw new CustomerManagementException("error: input customer lastname");
		}
		List<Customer> customerList = clientOutputPort.findByCustomerLastname(customerLastname);
		if(customerList.isEmpty()) {
			throw new CustomerManagementException("error: customer "+customerLastname+" not found");
		}

		List<CustomerDto> customerListDto = new ArrayList<>();
		customerList.forEach(customer -> {
			CustomerDto customerDto = CustomerEntityMapping.mapClientEntityToClientDto(customer);
			customerDto.setId(customer.getId());
			customerListDto.add(customerDto);
		});
		return customerListDto;
	}

	@Override
	public List<CustomerDto> getByCustomerRisk(String risk) {
		risk = customerNormalization2(risk);
		List<Customer> customerList = clientOutputPort.findByCustomerRisk(risk);
		List<CustomerDto> customerDtoList = new ArrayList<>();
		customerList.forEach(customer -> {
			CustomerDto customerDto = CustomerEntityMapping.mapClientEntityToClientDto(customer);
			customerDto.setId(customer.getId());
			customerDtoList.add(customerDto);
		});
		return customerDtoList;
	}

	@Override
	public List<CustomerDto> getByCustomerStatus(String status) {

		status = customerNormalization2(status);
		List<Customer> customerList = clientOutputPort.findByCustomerRisk(status);
		List<CustomerDto> customerDtoList = new ArrayList<>();
		customerList.forEach(customer -> {
			CustomerDto customerDto = CustomerEntityMapping.mapClientEntityToClientDto(customer);
			customerDto.setId(customer.getId());
			customerDtoList.add(customerDto);
		});
		return customerDtoList;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {

		List<Customer> customerList = clientOutputPort.findAllCustomers();
		List<CustomerDto> customerDtoList = new ArrayList<>();
		customerList.forEach(customer -> {
			CustomerDto customerDto = CustomerEntityMapping.mapClientEntityToClientDto(customer);
			customerDto.setId(customer.getId());
			customerDtoList.add(customerDto);
		});
		return customerDtoList;
	}

	@Override
	public Optional<CustomerDto> setCustomerRisk(String customerId, String risk) throws CustomerManagementException {

		customerId = customerNormalization2(customerId);
		risk = customerNormalization2(customerId);
		if(customerId.isEmpty() || risk.isEmpty()) {
			throw new CustomerManagementException("error: enter the customer id and risk");
		}

		Optional.of(clientOutputPort.findByCustomerId(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
				));
		//else
		Optional<Customer> newCustomer = clientOutputPort.updateCustomerRisk(customerId, risk);
		Optional<CustomerDto> newCustomerDto = newCustomer.map(CustomerEntityMapping::mapClientEntityToClientDto);

		newCustomerDto.get().setId(newCustomer.get().getId());
		return newCustomerDto;
	}

	@Override
	public Optional<CustomerDto> setCustomerStatus(String customerId, String status) throws CustomerManagementException {
		customerId = customerNormalization2(customerId);
		status = customerNormalization2(status);

		if(customerId.isEmpty() || status.isEmpty()) {
			throw new CustomerManagementException("error: enter the customer id and the status");
		}

		Optional.of(clientOutputPort.findByCustomerId(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
				));
		//else
		Optional<Customer> newCustomer = clientOutputPort.updateCustomerStatus(customerId, status);
		Optional<CustomerDto> newCustomerDto = newCustomer.map(CustomerEntityMapping::mapClientEntityToClientDto);

		newCustomerDto.get().setId(newCustomer.get().getId());
		return newCustomerDto;

	}

	@Override
	public Optional<CustomerDto> setCustomerLastname(String customerId, String lastname) throws CustomerManagementException {
		customerId = customerNormalization2(customerId);
		lastname = customerNormalization2(lastname);
		if(customerId.isEmpty() || lastname.isEmpty()) {
			throw new CustomerManagementException("error: enter the customer id and the lastname");
		}
		Optional.of(clientOutputPort.findByCustomerId(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
				));
		//else
		Optional<Customer> newCustomer = clientOutputPort.updateCustomerLastname(customerId, lastname);
		Optional<CustomerDto> newCustomerDto = newCustomer.map(CustomerEntityMapping::mapClientEntityToClientDto);
		newCustomerDto.get().setId(newCustomer.get().getId());

		return newCustomerDto;
	}

	@Override
	public Optional<CustomerDto> setCustomerFirstname(String customerId, String firstname)
			throws CustomerManagementException {

		customerId = customerNormalization2(customerId);
		firstname = customerNormalization2(firstname);
		if(customerId.isEmpty() || firstname.isEmpty()) {
			throw new CustomerManagementException("error: enter the customer id and the firstname");
		}
		Optional.of(clientOutputPort.findByCustomerId(customerId)
				.orElseThrow(
						() -> new CustomerManagementException("error: customer not found")
				));
		//else
		Optional<Customer> newCustomer = clientOutputPort.updateCustomerFirstname(customerId, firstname);
		Optional<CustomerDto> newCustomerDto = newCustomer.map(CustomerEntityMapping::mapClientEntityToClientDto);
		newCustomerDto.get().setId(newCustomer.get().getId());

		return newCustomerDto;
	}

	private CustomerDto customerNormalization1(CustomerDto customerDto) {
		//data normalization
		customerDto.setLastname(customerDto.getLastname().strip());
		customerDto.setFirstname(customerDto.getFirstname().strip());
		return customerDto;
	}

	private String customerNormalization2(String customerParam) {

		customerParam = customerParam.strip();
		return customerParam;
	}
}

