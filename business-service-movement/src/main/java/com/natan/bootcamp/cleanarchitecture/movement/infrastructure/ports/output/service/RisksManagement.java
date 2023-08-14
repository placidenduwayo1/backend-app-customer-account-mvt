package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.service;


import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Risk;
import com.natan.bootcamp.cleanarchitecture.movement.domain.exceptions.MovementManagementException;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.dto.CustomerDto;

public class RisksManagement {

    public static void manageRisks(CustomerDto customerDto, AccountDto accountDto, double mvtAmount)
            throws  MovementManagementException {

        double balance = accountDto.getBalance();
        double coverageAmount = accountDto.getCoverageAmount();

        if(customerDto.getRisk().equals(Risk.FAIBLE)){
            balance -= coverageAmount + coverageAmount *0.01;
        }
        else if (customerDto.getRisk().equals(Risk.IMPORTANT)){
            balance -= coverageAmount + coverageAmount *0.03;
        }
        if(mvtAmount > balance){
            throw new MovementManagementException("error: balance not enough for the mvt");
        }
    }
}
