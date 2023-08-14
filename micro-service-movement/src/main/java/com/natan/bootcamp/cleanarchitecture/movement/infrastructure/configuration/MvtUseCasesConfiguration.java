package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.configuration;

import com.natan.bootcamp.cleanarchitecture.movement.domain.ports.output.IMovementOutputPort;
import com.natan.bootcamp.cleanarchitecture.movement.domain.usecase.MovementUseCase;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MvtUseCasesConfiguration {

	@Bean
	@Qualifier("fooFormatter")
	public MovementUseCase implementMvtUseCase(@Autowired IMovementOutputPort outputPort) {
		
		return new MovementUseCase(outputPort);
	}
	
	@Bean
	public MovementService implementMvtServices() {
		
		return new MovementService();
	}
	
}