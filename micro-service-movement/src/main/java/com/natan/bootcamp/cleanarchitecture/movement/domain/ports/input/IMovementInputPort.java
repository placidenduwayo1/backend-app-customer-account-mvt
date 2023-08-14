package com.natan.bootcamp.cleanarchitecture.movement.domain.ports.input;

import com.natan.bootcamp.cleanarchitecture.movement.domain.dto.MovementDto;
import com.natan.bootcamp.cleanarchitecture.movement.domain.exceptions.MovementManagementException;

import java.util.List;
import java.util.Optional;

public interface IMovementInputPort {

	MovementDto createMovement(MovementDto mvtDto) throws MovementManagementException;
	Optional<MovementDto> getByMovementId(String mvtId) throws MovementManagementException;
	List<MovementDto> getByMovementSens(String sens) throws MovementManagementException;
	List<MovementDto> getByDate(String mvtDate);
	List<MovementDto> getAllMovements();
}
