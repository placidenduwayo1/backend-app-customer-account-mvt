package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.input.restmplate;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.input.dto.CustomerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerGetter {
    private static final String CUSTOMERURL=
            "http://localhost:8085/path/getcustomerbyid";

    public static CustomerDto getCustomerFromOutside(String customerId) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .build();
        CustomerDto customerDto = restTemplate.getForObject(
                CUSTOMERURL+"/"+customerId, CustomerDto.class);
        return  customerDto;
    }
}
