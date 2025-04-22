package com.zepto.db.controller;


import com.zepto.db.model.WareHouseProducts;
import com.zepto.db.repository.WareHouseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/warehouse/product")
public class WareHouseProductController {
    @Autowired
    WareHouseProductRepository wareHouseProductRepository;

    @PostMapping("/save")
    public WareHouseProducts addProduct(@RequestBody WareHouseProducts wareHouseProducts){
        wareHouseProductRepository.save(wareHouseProducts);
        return wareHouseProducts;
    }

    @GetMapping("/{wid}")
    public List<WareHouseProducts> getAllProductByWid(@PathVariable UUID wid){
        return wareHouseProductRepository.getWareHouseProductByWid(wid);
    }

    @GetMapping("/{wid}/{pid}")
    public WareHouseProducts getProductByWidPid(@PathVariable UUID wid, @PathVariable UUID pid){
        return wareHouseProductRepository.getProductByWidPid(wid,pid);
    }
}
