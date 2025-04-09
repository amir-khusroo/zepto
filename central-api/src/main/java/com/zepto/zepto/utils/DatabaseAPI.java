package com.zepto.zepto.utils;

import com.zepto.zepto.models.AppUser;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class DatabaseAPI {
    String dbApiUrl="/api/v1/db";

    public AppUser callCreateUserEndpoints(AppUser user){
        String url="http://localhost:8081"+dbApiUrl+"user/save";
        URI finalUrl=URI.create(url);
        RequestEntity request=RequestEntity.post(finalUrl).body(user);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<AppUser> response =restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        return response.getBody();
    }
}
