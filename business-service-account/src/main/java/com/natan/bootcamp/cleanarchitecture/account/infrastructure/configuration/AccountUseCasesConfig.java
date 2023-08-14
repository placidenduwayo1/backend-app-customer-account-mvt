package com.natan.bootcamp.cleanarchitecture.account.infrastructure.configuration;

import com.natan.bootcamp.cleanarchitecture.account.domain.ports.output.IAccountOutputPort;
import com.natan.bootcamp.cleanarchitecture.account.domain.usecase.AccountUseCase;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AccountUseCasesConfig {
	@Bean
	@Qualifier("fooFormatter")
	public AccountUseCase implementAccountUseCase(@Autowired IAccountOutputPort outputPort) {
		return new AccountUseCase(outputPort);
	}
	
	@Bean
	public AccountService implementAccountServices() {
		
		return new AccountService();
	}

}