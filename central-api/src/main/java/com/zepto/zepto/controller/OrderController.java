package com.zepto.zepto.controller;

import com.zepto.zepto.requestDTO.RequestOrderProductDTO;
import com.zepto.zepto.responsedto.ResponseBillDTO;
import com.zepto.zepto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseBillDTO placeOrder(@RequestBody List<RequestOrderProductDTO> products, @RequestParam UUID userId){
        return orderService.placeOrder(products,userId);
    }
}
