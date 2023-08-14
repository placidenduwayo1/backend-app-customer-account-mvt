package com.natan.bootcamp.cleanarchitecture.riskmanager.outside.resttemplate;

import com.natan.bootcamp.cleanarchitecture.riskmanager.outside.dto.AccountDto;
import org.springframework.web.client.RestTemplate;

public class AccountGetter {

    private static final String ACCOUNTURL = "http://localhost:8086/path/getbyaccountid";
    public static AccountDto getAccountDtoFromOutside(String accountId){

        RestTemplate restTemplate = new RestTemplate();
        AccountDto accountDto = restTemplate.getForObject(
                ACCOUNTURL+"/"+accountId, AccountDto.class);

        return accountDto;

    }
}
