package com.zepto.db.controller;

import com.zepto.db.model.Product;
import com.zepto.db.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("save")
    public Product createProduct(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @GetMapping("/{pid}")
    public Product getProductById(@PathVariable UUID pid){
        return productRepository.findById(pid).orElse(null);
    }
}
