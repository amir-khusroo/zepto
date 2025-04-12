package com.zepto.db.controller;

import com.zepto.db.model.Product;
import com.zepto.db.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }
}
