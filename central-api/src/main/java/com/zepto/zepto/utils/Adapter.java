package com.zepto.zepto.utils;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.models.Product;
import com.zepto.zepto.models.WareHouse;
import com.zepto.zepto.models.WareHouseProduct;
import com.zepto.zepto.requestDTO.RegisterProductDTO;
import com.zepto.zepto.requestDTO.RegisterUserDTO;
import com.zepto.zepto.requestDTO.RegisterWareHouseProductDTO;
import com.zepto.zepto.requestDTO.RequestWarehouseDTO;
import org.springframework.stereotype.Component;

@Component
public class Adapter {
    public AppUser mapUserRequestBodyToAppUser(RegisterUserDTO user){
        AppUser appUser=AppUser.builder()
                .name(user.getName())
                .userType(user.getUserType().toString())
                .email(user.getEmail())
                .address((user.getAddress()))
                .pincode(user.getPincode())
                .status("ACTIVE")
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return appUser;
    }

    public Product mapRegisterProductToProduct(RegisterProductDTO productDTO){
        Product product=Product.builder()
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .details((productDTO.getDetails()))
                .weight(productDTO.getWeight())
                .rating(0.0)
                .manufacturerEmail(productDTO.getManufacturerEmail())
                .totalPurchase(0)
                .build();
        return product;
    }

    public WareHouse mapRegisterWareHouseDTOTOWareHouse(RequestWarehouseDTO warehouseDTO, AppUser manager){
        WareHouse wareHouse=WareHouse.builder()
                .name(warehouseDTO.getName())
                .pincode(warehouseDTO.getPincode())
                .address(warehouseDTO.getPincode())
                .email(warehouseDTO.getEmail())
                .manager(manager)
                .build();
        return wareHouse;
    }

    public WareHouseProduct mapWarehouseProductDTOToWarehouseProduct(RegisterWareHouseProductDTO wareHouseProductDTO){
        WareHouseProduct wareHouseProduct=WareHouseProduct.builder()
                .wid(wareHouseProductDTO.getWid())
                .pid(wareHouseProductDTO.getPid())
                .discount(wareHouseProductDTO.getDiscount())
                .totalQuantity(wareHouseProductDTO.getTotalQuantity())
                .build();
        return wareHouseProduct;
    }

}
