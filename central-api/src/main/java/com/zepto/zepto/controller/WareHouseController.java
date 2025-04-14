package com.zepto.zepto.controller;

import com.zepto.zepto.models.WareHouse;
import com.zepto.zepto.models.WareHouseProduct;
import com.zepto.zepto.requestDTO.RegisterWareHouseProductDTO;
import com.zepto.zepto.requestDTO.RequestWarehouseDTO;
import com.zepto.zepto.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/warehouse")
public class WareHouseController {
    @Autowired
    WareHouseService wareHouseService;

    @PostMapping("/create")
    public WareHouse createWareHouse(@RequestParam UUID userId, @RequestBody RequestWarehouseDTO warehouseDTO){
        WareHouse wareHouse=wareHouseService.createWarehouse(userId,warehouseDTO);
        return wareHouse;
    }

    @PostMapping("/addproduct")
    public WareHouseProduct addProductToWarehouse(@RequestParam UUID userId, @RequestBody RegisterWareHouseProductDTO wareHouseProductDTO){
        return wareHouseService.addWarehouseProduct(wareHouseProductDTO,userId);
    }
}
