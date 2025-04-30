package com.zepto.zepto.controller;

import com.zepto.zepto.requestDTO.RequestOrderProductDTO;
import com.zepto.zepto.responsedto.ResponseBillDTO;
import com.zepto.zepto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody List<RequestOrderProductDTO> products, @RequestParam UUID userId){
        try {
            ResponseBillDTO bill=orderService.placeOrder(products,userId);
            return  new ResponseEntity<>(bill, HttpStatus.CREATED);
        }
        catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
