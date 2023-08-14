package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.mapping;

import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Movement;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.model.MovementModel;

public class MovementModelMapping {
	//map Movement Model to Movement Entity
	public static Movement mapMovementModelToMovementEntity(MovementModel mvtModel) {
		Movement mvt = new Movement();
		mvt.setNumMvt(mvtModel.getNum());
		mvt.setNumAccount(mvtModel.getNumAccount());
		mvt.setAmount(mvtModel.getAmount());
		mvt.setMvtSens(mvtModel.getMvtSens());
		mvt.setMvtDate(mvtModel.getMvtDate());
		
		return mvt;
	}
	
	//map Movement Entity to Movement Model 
	public static MovementModel mapMovementEntityToMovementModel(Movement mvt) {
		MovementModel mvtModel = new MovementModel();
		mvtModel.setNum(mvt.getNumMvt());
		mvtModel.setNumAccount(mvt.getNumAccount());
		mvtModel.setAmount(mvt.getAmount());
		mvtModel.setMvtSens(mvt.getMvtSens());
		mvtModel.setMvtDate(mvt.getMvtDate());
		
		return mvtModel;
	}
}
