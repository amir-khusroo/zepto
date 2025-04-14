package com.zepto.zepto.utils;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.models.Product;
import com.zepto.zepto.models.WareHouse;
import com.zepto.zepto.models.WareHouseProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

@Component
public class DatabaseAPIUtil extends ApiUtilImpl{
    @Value("${db.api.url}")
    String dbApiUrl;

    @Autowired
    ModelMapper mapper;

    public AppUser callCreateUserEndpoints(AppUser user){
        Object resp = makePostCall(dbApiUrl, "/user/save", new HashMap<>(), user);
        AppUser userResp = mapper.map(resp, AppUser.class);
        return userResp;
    }

    public AppUser getUserByEmail(String userEmail) {
        String endPoint =  "/user/email/" + userEmail;
        Object resp  = makeGetCall(dbApiUrl, endPoint, new HashMap<>());
        return mapper.map(resp, AppUser.class);
    }

    public Product callCreateProductEndPoint(Product product) {
        Object resp = makePostCall(dbApiUrl, "/product/save", new HashMap<>(), product);
        return mapper.map(resp, Product.class);
    }

    public  AppUser getUserByUserId(UUID userId){
        String endPoint="/user/"+userId.toString();
        Object resp=makeGetCall(dbApiUrl,endPoint,new HashMap<>());
        return  mapper.map(resp,AppUser.class);
    }

    public WareHouse createWareHouse(WareHouse wareHouse){
        String endPoint="/warehose/save";
        Object resp=makePostCall(dbApiUrl,endPoint,new HashMap<>(),wareHouse);
        return  mapper.map(resp,WareHouse.class);
    }

    public WareHouseProduct createWareHouseProduct(WareHouseProduct wareHouseProduct){
        String endPoint="warehouse/product/save";
        Object resp=makePostCall(dbApiUrl,endPoint,new HashMap<>(),wareHouseProduct);
        return mapper.map(resp, WareHouseProduct.class);
    }
}
