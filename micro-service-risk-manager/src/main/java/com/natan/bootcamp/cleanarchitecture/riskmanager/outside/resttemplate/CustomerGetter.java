package com.natan.bootcamp.cleanarchitecture.riskmanager.outside.resttemplate;

import com.natan.bootcamp.cleanarchitecture.riskmanager.outside.dto.CustomerDto;
import org.springframework.web.client.RestTemplate;

public class CustomerGetter {

    private static final String CUSTOMERURL = "http://localhost:8085/path/getcustomerbyid";

    public static CustomerDto getCustomerDtoFromOutside(String customerId){

        RestTemplate restTemplate = new RestTemplate();
        CustomerDto customerDto = restTemplate.getForObject(
                CUSTOMERURL+"/"+customerId, CustomerDto.class
        );

        return customerDto;
    }
}
