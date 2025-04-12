package com.zepto.zepto.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper mapper=new ModelMapper();
        return mapper;
    }

}
