package com.natan.bootcamp.cleanarchitecture.movement.domain.mapping;

import com.natan.bootcamp.cleanarchitecture.movement.domain.dto.MovementDto;
import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Movement;
public class MovementEntityMapping {

	//map Movement Entity to Movement Dto
	public static MovementDto mapMovementEntityToMovementDto(Movement mvt) {
		
		MovementDto mvtDto = new MovementDto();
		mvtDto.setNumMvt(mvt.getNumMvt());
		mvtDto.setNumAccount(mvt.getNumAccount());
		mvtDto.setAmount(mvt.getAmount());
		mvtDto.setMvtSens(mvt.getMvtSens());
		
		return mvtDto;
	}
	
	//map Movement Dto to Movement Entity
	public static Movement mapMovementDtoToMovementEntity(MovementDto mvtDto) {
		
		Movement mvt = new Movement();
		mvt.setNumMvt(mvtDto.getNumMvt());
		mvt.setNumAccount(mvtDto.getNumAccount());
		mvt.setAmount(mvtDto.getAmount());
		mvt.setMvtSens(mvtDto.getMvtSens());
		
		return mvt;
	}
}
