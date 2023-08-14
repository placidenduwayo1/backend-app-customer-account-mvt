package com.natan.bootcamp.cleanarchitecture.movement.domain.usecase;

import com.natan.bootcamp.cleanarchitecture.movement.domain.dto.MovementDto;
import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Movement;
import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.MvtSens;
import com.natan.bootcamp.cleanarchitecture.movement.domain.exceptions.MovementManagementException;
import com.natan.bootcamp.cleanarchitecture.movement.domain.mapping.MovementEntityMapping;
import com.natan.bootcamp.cleanarchitecture.movement.domain.ports.input.IMovementInputPort;
import com.natan.bootcamp.cleanarchitecture.movement.domain.ports.output.IMovementOutputPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovementUseCase implements IMovementInputPort {

	private final IMovementOutputPort mvtOutputPort;
	
	public MovementUseCase(IMovementOutputPort mvtOutputPort) {
		super();
		this.mvtOutputPort = mvtOutputPort;
	}

	@Override
	public MovementDto createMovement(MovementDto mvtDto) throws MovementManagementException{
		mvtDto.setNumAccount(mvtDto.getNumAccount().strip());
		if( mvtDto.getNumAccount().isEmpty() || mvtDto.getAmount() <=0) {
			throw new MovementManagementException("fields of mvt are mandatory");
		}

		Movement mappedMvt = MovementEntityMapping.mapMovementDtoToMovementEntity(mvtDto);
		mvtOutputPort.saveMovement(mappedMvt);
		mvtDto.setNumMvt(mappedMvt.getNumMvt());

		return mvtDto;
	}

	@Override
	public Optional<MovementDto> getByMovementId(String mvtId) throws MovementManagementException {
		mvtId = mvtId.strip();
		Optional<Movement> mvt = Optional.of(mvtOutputPort.findByMovementId(mvtId)
				.orElseThrow(
						() -> new MovementManagementException("error: mvt not found")
						));

		return mvt.map(MovementEntityMapping::mapMovementEntityToMovementDto);
	}

	@Override
	public List<MovementDto> getByMovementSens(String sens) throws MovementManagementException {
		sens = sens.strip().toUpperCase();
		if(! sens.equals(MvtSens.ACHAT) && !sens.equals(MvtSens.VENTE)){
			throw new MovementManagementException("error: managed sens "+MvtSens.ACHAT+" or "+MvtSens.VENTE);
		}
		List<Movement> listMvts = mvtOutputPort.findByMovementSens(sens);
		return listMvts.stream()
				.map(MovementEntityMapping::mapMovementEntityToMovementDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<MovementDto> getByDate(String mvtDate) {
		mvtDate = mvtDate.strip();
		List<Movement> listMvts = mvtOutputPort.findByDate(mvtDate);
		return listMvts.stream()
				.map(MovementEntityMapping::mapMovementEntityToMovementDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<MovementDto> getAllMovements() {
		
		List<Movement> listMvts = mvtOutputPort.findAllMovements();

		return listMvts.stream()
				.map(MovementEntityMapping::mapMovementEntityToMovementDto)
				.collect(Collectors.toList());
	}
	
}
