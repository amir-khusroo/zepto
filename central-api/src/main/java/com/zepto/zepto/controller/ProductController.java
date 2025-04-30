package com.zepto.zepto.controller;

import com.zepto.zepto.models.Product;
import com.zepto.zepto.requestDTO.RegisterProductDTO;
import com.zepto.zepto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ResponseEntity createProduct(@RequestBody RegisterProductDTO product, @RequestParam String userEmail){
        try {
            Product productResp=productService.createProduct(product,userEmail);
            return new ResponseEntity(productResp, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
