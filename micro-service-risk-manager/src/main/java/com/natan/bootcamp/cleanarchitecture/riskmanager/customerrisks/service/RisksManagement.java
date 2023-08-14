package com.natan.bootcamp.cleanarchitecture.riskmanager.customerrisks.service;

import com.natan.bootcamp.cleanarchitecture.riskmanager.customerrisks.enumtypes.Risk;
import com.natan.bootcamp.cleanarchitecture.riskmanager.customerrisks.exceptions.RiskManagementException;
import com.natan.bootcamp.cleanarchitecture.riskmanager.outside.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.riskmanager.outside.dto.CustomerDto;

public class RisksManagement {

    public RisksManagement manageRisks(CustomerDto customerDto, AccountDto accountDto, double mvtAmount)
            throws RiskManagementException {

        double balance = accountDto.getBalance();
        double coverageAmount = accountDto.getCoverageAmount();

        if(customerDto.getRisk().equals(Risk.FAIBLE)){
            balance -= coverageAmount + coverageAmount *0.01;
        }
        else if (customerDto.getRisk().equals(Risk.IMPORTANT)){
            balance -= coverageAmount + coverageAmount *0.03;
        }
        if(mvtAmount > balance){
            throw new RiskManagementException("error: balance <"+ balance+ ">not enough for the mvt");
        }

        return this;
    }
}
