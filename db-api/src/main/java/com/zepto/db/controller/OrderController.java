package com.zepto.db.controller;

import com.zepto.db.model.AppOrder;
import com.zepto.db.repository.AppOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/order")
public class OrderController {
    @Autowired
    AppOrderRepository appOrderRepository;

    @PostMapping("/save")
    public AppOrder createOrder(@RequestBody AppOrder order){
        return appOrderRepository.save(order);
    }

}
