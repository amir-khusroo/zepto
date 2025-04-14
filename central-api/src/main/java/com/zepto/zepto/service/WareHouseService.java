package com.zepto.zepto.service;

import com.zepto.zepto.enums.UserType;
import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.models.WareHouse;
import com.zepto.zepto.models.WareHouseProduct;
import com.zepto.zepto.requestDTO.RegisterWareHouseProductDTO;
import com.zepto.zepto.requestDTO.RequestWarehouseDTO;
import com.zepto.zepto.utils.Adapter;
import com.zepto.zepto.utils.DatabaseAPIUtil;
import com.zepto.zepto.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WareHouseService {
    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    Adapter adapter;

    @Autowired
    UserUtil userUtil;

    public WareHouse createWarehouse(UUID userId, RequestWarehouseDTO warehouseDTO){
        AppUser user=databaseAPIUtil.getUserByUserId(userId);
        if(user==null){
            throw new RuntimeException("User with does not exist");
        }
        if (!user.getUserType().equals(UserType.APPLICATION_ADMIN.toString())){
            throw new RuntimeException("You do not have access to create warehouse");
        }
        UUID managerId=warehouseDTO.getManagerId();
        AppUser manager=databaseAPIUtil.getUserByUserId(managerId);
        WareHouse wareHouse=adapter.mapRegisterWareHouseDTOTOWareHouse(warehouseDTO,manager);
        return databaseAPIUtil.createWareHouse(wareHouse);
    }

    public WareHouseProduct addWarehouseProduct(RegisterWareHouseProductDTO wareHouseProductDTO, UUID userId){
        AppUser user=databaseAPIUtil.getUserByUserId(userId);
        if(!userUtil.isZeptoWareHouseManager(user) && !userUtil.isZeptoApplicationAdmin(user)){
            throw new RuntimeException("You do not have access to add products into system");
        }
        WareHouseProduct wareHouseProduct=adapter.mapWarehouseProductDTOToWarehouseProduct(wareHouseProductDTO);
        return databaseAPIUtil.createWareHouseProduct(wareHouseProduct);
    }
}
