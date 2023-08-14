package com.natan.bootcamp.cleanarchitecture.riskmanager.outside.riskcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskManagerController {


    @GetMapping(value = "/getriskmanager")
    public void getRiskManager(){

    }
}
