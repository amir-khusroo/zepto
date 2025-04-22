package com.zepto.db.controller;

import com.zepto.db.model.WareHouse;
import com.zepto.db.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/db/warehouse")
public class WareHouseController {
    WareHouseRepository wareHouseRepository;
    @Autowired
    public WareHouseController(WareHouseRepository wareHouseRepository){
        this.wareHouseRepository=wareHouseRepository;
    }

    @GetMapping("/{wareHouseId}")
    public WareHouse getWareHouseById(@PathVariable UUID wareHouseId){
        return wareHouseRepository.findById(wareHouseId).orElse(null);
    }

    @PostMapping("/save")
    public WareHouse createWareHouse(@RequestBody WareHouse wareHouse){
        wareHouseRepository.save(wareHouse);
        return wareHouse;
    }

    @PutMapping("/update")
    public WareHouse updateWareHouse(@RequestBody WareHouse wareHouse){
        wareHouseRepository.save(wareHouse);
        return wareHouse;
    }

    @GetMapping("/pincode/{pincode}")
    public WareHouse getWareHouseByPincode(@PathVariable String pincode){
        return wareHouseRepository.findByPincode(pincode);
    }

}
