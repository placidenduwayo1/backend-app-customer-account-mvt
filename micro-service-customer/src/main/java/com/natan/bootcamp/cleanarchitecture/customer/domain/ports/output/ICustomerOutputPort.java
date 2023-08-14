package com.natan.bootcamp.cleanarchitecture.customer.domain.ports.output;

import java.util.List;
import java.util.Optional;

import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Customer;
import com.natan.bootcamp.cleanarchitecture.customer.domain.exceptions.CustomerManagementException;

public interface ICustomerOutputPort {
	
	Customer saveClient(Customer client) throws CustomerManagementException;
	
	Optional<Customer> findByCustomerId(String customerId) throws CustomerManagementException;
	List<Customer> findByCustomerLastname(String clientLastname) throws CustomerManagementException;
	List<Customer> findAllCustomers();
	
	List<Customer> findByCustomerRisk(String risk);
	List<Customer> findByCustomerStatus(String status);
	
	Optional<Customer> updateCustomerRisk(String clientId, String risk) throws CustomerManagementException;
	Optional<Customer> updateCustomerStatus(String clientId, String status) throws CustomerManagementException;
	Optional<Customer> updateCustomerLastname(String clientId, String lastname) throws CustomerManagementException;
	Optional<Customer> updateCustomerFirstname(String clientId, String firstname) throws CustomerManagementException;

}
