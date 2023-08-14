package com.natan.bootcamp.cleanarchitecture.movement.domain.ports.output;

import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Movement;
import com.natan.bootcamp.cleanarchitecture.movement.domain.exceptions.MovementManagementException;

import java.util.List;
import java.util.Optional;

public interface IMovementOutputPort {

	Movement saveMovement(Movement mvt) throws MovementManagementException;
	Optional<Movement> findByMovementId(String mvtId) throws MovementManagementException;
	List<Movement> findByMovementSens(String sens);
	List<Movement> findByDate(String mvtDate);
	List<Movement> findAllMovements();
}
