package com.zepto.zepto.service;

import com.zepto.zepto.enums.UserType;
import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.models.Product;
import com.zepto.zepto.requestDTO.RegisterProductDTO;
import com.zepto.zepto.utils.Adapter;
import com.zepto.zepto.utils.DatabaseAPIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    Adapter adapter;

    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    public Product createProduct(RegisterProductDTO product,String userEmail){
        Product productObj=adapter.mapRegisterProductToProduct(product);
        AppUser user=databaseAPIUtil.getUserByEmail(userEmail);
        if(user==null){
            throw new RuntimeException("User not found with this Email");
        }
        if(!user.getUserType().equals(UserType.APPLICATION_ADMIN.toString())){
            throw new RuntimeException("User does not have access to create product");
        }
        Product productResp=databaseAPIUtil.callCreateProductEndPoint(productObj);
        return productResp;
    }

}
