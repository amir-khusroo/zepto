package com.zepto.zepto.utils;

import com.zepto.zepto.models.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
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

    public WareHouse getWareHouseByPincode(String pincode){
        String endPoint="/warehouse/pincode"+pincode;
        Object resp=makeGetCall(dbApiUrl,endPoint,new HashMap<>());
        if(resp==null){
            return null;
        }
        return mapper.map(resp,WareHouse.class);
    }

    public List<WareHouseProduct> getProductsByWareHouseId(UUID wid){
        String endPoint="/warehouse/product/"+wid.toString();
        Object resp=makeGetCall(dbApiUrl,endPoint,new HashMap<>());
        Type listType=new TypeToken<List<WareHouseProduct>>(){}.getType();
        return mapper.map(resp,listType);
    }

    public Product getProductByProductId(UUID pid){
        String endPoint="/product/"+pid.toString();
        Object resp=makeGetCall(dbApiUrl,endPoint,new HashMap<>());
        return mapper.map(resp,Product.class);
    }

    public WareHouseProduct getProductByWidPid(UUID wid,UUID pid){
        String endPoint="/warehouse/product/"+wid.toString()+"/"+pid.toString();
        Object resp=makeGetCall(dbApiUrl,endPoint,new HashMap<>());
        return mapper.map(resp,WareHouseProduct.class);
    }

    public AppOrder saveOrder(AppOrder order){
        String endpoint="/order/save";
        Object resp=makePostCall(dbApiUrl,endpoint,new HashMap<>(),order);
        return mapper.map(resp,AppOrder.class);
    }
}
