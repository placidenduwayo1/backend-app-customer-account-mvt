package com.natan.bootcamp.cleanarchitecture.customer.domain.mapping;

import com.natan.bootcamp.cleanarchitecture.customer.domain.dto.CustomerDto;
import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Customer;

public class CustomerEntityMapping {

	//convert Client Entity to Client Dto
	public static CustomerDto mapClientEntityToClientDto(Customer customer) {
		
		CustomerDto cltDto = new CustomerDto();
		cltDto.setLastname(customer.getLastname());
		cltDto.setFirstname(customer.getFirstname());
		cltDto.setRisk(customer.getRisk());
		cltDto.setStatus(customer.getStatus());
		cltDto.setCreationDate(customer.getCreationDate());
		
		return cltDto;
	}
	
	//convert Client Dto to Client Entity
	public static Customer mapClientDtoToClientEntity(CustomerDto customerDto) {
			
		Customer customer = new com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Customer();
		customer.setLastname(customerDto.getLastname());
		customer.setFirstname(customerDto.getFirstname());
		customer.setRisk(customerDto.getRisk());
		customer.setStatus(customerDto.getStatus());
			
		return customer;
		}
}
