package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.controller;

import com.natan.bootcamp.cleanarchitecture.movement.domain.dto.MovementDto;
import com.natan.bootcamp.cleanarchitecture.movement.domain.exceptions.MovementManagementException;
import com.natan.bootcamp.cleanarchitecture.movement.domain.ports.input.IMovementInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovementController {

	@Autowired
	private IMovementInputPort mvtInputPort;
	
	@RequestMapping(value = "/savemvt")
	public ResponseEntity<MovementDto> saveMvt(@RequestBody MovementDto mvtDo)
			throws MovementManagementException {
		
		MovementDto mvtD = mvtInputPort.createMovement(mvtDo);
		
		return new ResponseEntity<MovementDto>(mvtD, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/getmvtbyid/{mvtId}", method = RequestMethod.GET)
	public Optional<MovementDto> getMovementById(@PathVariable("mvtId") String mvtId) 
			throws MovementManagementException {
		
		return mvtInputPort.getByMovementId(mvtId);
	}
	
	@RequestMapping(value = "/getallmvtsbysens", method = RequestMethod.GET)
	public List<MovementDto> getAllMvtBySens(String sens) throws MovementManagementException {
		return mvtInputPort.getByMovementSens(sens);
	}
	
	@RequestMapping(value = "/getallmvtsbydate", method = RequestMethod.GET)
	public List<MovementDto> getAllMvtsByDte(String date){
		
		return mvtInputPort.getByDate(date);
	}
	
	@RequestMapping(value = "/getallmvts", method = RequestMethod.GET)
	public List<MovementDto> getAllMvts(){
		
		return mvtInputPort.getAllMovements();
	}
}
