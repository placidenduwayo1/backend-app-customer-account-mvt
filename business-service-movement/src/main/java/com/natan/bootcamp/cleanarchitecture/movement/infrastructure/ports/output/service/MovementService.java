package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.service;

import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Movement;
import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.MvtSens;
import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Status;
import com.natan.bootcamp.cleanarchitecture.movement.domain.exceptions.MovementManagementException;
import com.natan.bootcamp.cleanarchitecture.movement.domain.ports.output.IMovementOutputPort;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.dto.CustomerDto;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.resttemplate.AccountGetter;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.resttemplate.CustomerGetter;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.mapping.MovementModelMapping;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.model.MovementModel;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.repository.IMovementCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovementService implements IMovementOutputPort {

	@Autowired
	private IMovementCrudRepository mvtRepository;

	@Override
	public Movement saveMovement(Movement mvt) throws MovementManagementException{

		AccountDto accountDto = AccountGetter.getAccountFromOutside(mvt.getNumAccount());
		CustomerDto customerDto = CustomerGetter.getCustomerFromOutside(accountDto.getCustomerId());

		if(customerDto.getStatus().equals(Status.HISTORISE)){
			throw new MovementManagementException("error: inactive client");
		}

		double mvtAmount = mvt.getAmount();

		MovementModel mvtModel = MovementModelMapping.mapMovementEntityToMovementModel(mvt);

		if(mvt.getMvtSens().equals(MvtSens.ACHAT)){
			RisksManagement.manageRisks(customerDto, accountDto, mvtAmount);
			mvtRepository.save(mvtModel);
		}
		else if(mvt.getMvtSens().equals(MvtSens.VENTE)){
		//	accountDto.setBalance(accountDto.getBalance()+mvtAmount);
			mvtRepository.save(mvtModel);
		}
		mvt.setNumMvt(mvtModel.getNum());
		return mvt;
	}

	@Override
	public Optional<Movement> findByMovementId(String mvtId) throws MovementManagementException {

		Optional<MovementModel> mvtModel = Optional.ofNullable(mvtRepository.findById(mvtId)
				.orElseThrow(
						() -> new MovementManagementException("error: mvt not found")
				));
		//else

		return mvtModel.map(MovementModelMapping::mapMovementModelToMovementEntity);
	}

	@Override
	public List<Movement> findByMovementSens(String sens) {
		
		List<MovementModel> listMvtsModel = mvtRepository.findByMvtSens(sens);

		return listMvtsModel.stream()
				.map(MovementModelMapping::mapMovementModelToMovementEntity)
				.collect(Collectors.toList());
	}

	@Override
	public List<Movement> findByDate(String mvtDate) {
		
		List<MovementModel> listMvtsModel = mvtRepository.findAllByMvtDate(mvtDate);

		return listMvtsModel.stream()
				.map(MovementModelMapping::mapMovementModelToMovementEntity)
				.collect(Collectors.toList());
	}

	@Override
	public List<Movement> findAllMovements() {
		
		List<MovementModel> listMvtsModel = mvtRepository.findAll();

		return listMvtsModel.stream()
				.map(MovementModelMapping::mapMovementModelToMovementEntity)
				.collect(Collectors.toList());
	}
}
