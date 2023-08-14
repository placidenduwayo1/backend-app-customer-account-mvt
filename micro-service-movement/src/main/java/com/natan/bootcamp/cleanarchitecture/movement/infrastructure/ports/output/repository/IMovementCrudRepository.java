package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.repository;

import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.model.MovementModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IMovementCrudRepository extends CrudRepository<MovementModel, String> {
	MovementModel save(MovementModel mvtModel);
	Optional<MovementModel> findById(String mvtId);
	List<MovementModel> findByMvtSens(String sens);
	List<MovementModel> findAllByMvtDate(String mvtDate);
	List<MovementModel> findAll();
}
