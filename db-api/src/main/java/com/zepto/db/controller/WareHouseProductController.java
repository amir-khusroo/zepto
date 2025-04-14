package com.zepto.db.controller;


import com.zepto.db.model.WareHouseProducts;
import com.zepto.db.repository.WareHouseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WareHouseProductController {
    @Autowired
    WareHouseProductRepository wareHouseProductRepository;

    @PostMapping("/save")
    public WareHouseProducts addProduct(@RequestBody WareHouseProducts wareHouseProducts){
        wareHouseProductRepository.save(wareHouseProducts);
        return wareHouseProducts;
    }
}
