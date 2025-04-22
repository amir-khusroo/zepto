package com.zepto.zepto.controller;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.models.Product;
import com.zepto.zepto.requestDTO.RegisterUserDTO;
import com.zepto.zepto.service.UserService;
import com.zepto.zepto.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/user")
public class UserController {
    private UserService userService;

    @Autowired
    private WareHouseService wareHouseService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public AppUser createUser(@RequestBody RegisterUserDTO user){
        AppUser response=userService.createUser(user);
        return response;
    }

    @GetMapping("/products/{userId}")
    public ResponseEntity getProductByPincode(@RequestParam UUID userId){
        try {
            List<Product> products=wareHouseService.getWareHouseProducts(userId);
            return new ResponseEntity(products, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
