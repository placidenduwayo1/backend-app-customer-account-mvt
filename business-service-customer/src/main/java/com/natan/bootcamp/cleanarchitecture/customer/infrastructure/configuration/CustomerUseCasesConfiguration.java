package com.natan.bootcamp.cleanarchitecture.customer.infrastructure.configuration;

import com.natan.bootcamp.cleanarchitecture.customer.domain.ports.output.ICustomerOutputPort;
import com.natan.bootcamp.cleanarchitecture.customer.domain.usecase.CustomerUseCase;
import com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerUseCasesConfiguration {

	@Bean
	@Qualifier("fooFormatter")
	public CustomerUseCase implementCustomerUseCaseOutputPort(@Autowired ICustomerOutputPort outPort) {
		return new CustomerUseCase(outPort);
	}
	
	@Bean
	public CustomerService implementCustomerPersistence() {
		
		return new CustomerService();
	}
}