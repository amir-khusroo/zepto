package com.zepto.zepto.utils;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class DatabaseAPIUtil {
    String dbApiUrl="/api/v1/db";

    public AppUser callCreateUserEndpoints(AppUser user){
        String url="http://localhost:8082"+dbApiUrl+"user/save";
        URI finalUrl=URI.create(url);
        RequestEntity request=RequestEntity.post(finalUrl).body(user);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<AppUser> response =restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        return response.getBody();
    }

    public AppUser getUserByEmail(String userEmail) {
        String url="http://localhost:8082"+dbApiUrl+"user/email";
        URI finalUrl=URI.create(url);
        RequestEntity request=RequestEntity.get(finalUrl).build();

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<AppUser> response=restTemplate.exchange(finalUrl,HttpMethod.GET,request, AppUser.class);
        return response.getBody();
    }

    public Product callCreateProductEndPoint(Product productObj) {
        String url="http://localhost:8082"+dbApiUrl+"/product/save";
        URI finalUrl=URI.create(url);

        RequestEntity request=RequestEntity.post(finalUrl).body(productObj);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Product> response=restTemplate.exchange(finalUrl,HttpMethod.POST,request,Product.class);
        return response.getBody();
    }
}
