package com.natan.bootcamp.cleanarchitecture.customer.domain.ports.input;

import com.natan.bootcamp.cleanarchitecture.customer.domain.dto.CustomerDto;
import com.natan.bootcamp.cleanarchitecture.customer.domain.exceptions.CustomerManagementException;

import java.util.List;
import java.util.Optional;

public interface ICustomerInputPort {

	CustomerDto createCustomer(CustomerDto customerDto) throws CustomerManagementException;

	Optional<CustomerDto> getByCustomerId(String customerId) throws CustomerManagementException;
	List<CustomerDto> getByCustomerLastname(String customerLastname) throws CustomerManagementException;
	List<CustomerDto> getByCustomerRisk(String risk);
	List<CustomerDto> getByCustomerStatus(String status);
	List<CustomerDto> getAllCustomers();

	Optional<CustomerDto> setCustomerRisk(String customerId, String risk) throws CustomerManagementException;
	Optional<CustomerDto> setCustomerStatus(String customerId, String status) throws CustomerManagementException;
	Optional<CustomerDto> setCustomerLastname(String customerId, String lastname) throws CustomerManagementException;
	Optional<CustomerDto> setCustomerFirstname(String customerId, String firstname) throws CustomerManagementException;
}
