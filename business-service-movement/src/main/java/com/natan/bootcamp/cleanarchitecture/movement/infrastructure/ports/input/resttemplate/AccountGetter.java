package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.resttemplate;

import com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.dto.AccountDto;
import org.springframework.web.client.RestTemplate;

public class AccountGetter {

    private static final String ACCOUNTURL= "http://localhost:8086/path/getaccountbyid";
    public static AccountDto getAccountFromOutside(String numAccount)  {
        RestTemplate restTemplate = new RestTemplate();
       AccountDto accountDto = restTemplate.getForObject(ACCOUNTURL+"/"+numAccount,
                AccountDto.class);
       return accountDto;
    }
}