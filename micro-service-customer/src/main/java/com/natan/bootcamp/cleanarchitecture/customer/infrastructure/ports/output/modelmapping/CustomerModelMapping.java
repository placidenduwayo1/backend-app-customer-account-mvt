package com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.modelmapping;

import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Customer;
import com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.model.CustomerModel;

public class CustomerModelMapping {
	
	//method to convert Client Model to Client Entity
	public static Customer mapCustomerModelToCustomerEntity(CustomerModel customerModel) {

		Customer customer = new Customer();
		customer.setId(customerModel.getId());
		customer.setLastname(customerModel.getLastname());
		customer.setFirstname(customerModel.getFirstname());
		customer.setRisk(customerModel.getRisk());
		customer.setStatus(customerModel.getStatus());
		customer.setCreationDate(customerModel.getCreationDate());
		
		
		return customer;
	}
	
	//method to convert Client Entity to Client model
	public static CustomerModel mapCustomerEntityToCustomerModel(Customer customer) {

		CustomerModel customerModel = new CustomerModel();
		customerModel.setId(customer.getId());
		customerModel.setLastname(customer.getLastname());
		customerModel.setFirstname(customer.getFirstname());
		customerModel.setRisk(customer.getRisk());
		customerModel.setStatus(customer.getStatus());
		customerModel.setCreationDate(customer.getCreationDate());
		
		return customerModel;
	}
}

