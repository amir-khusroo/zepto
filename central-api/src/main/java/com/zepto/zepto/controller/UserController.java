package com.zepto.zepto.controller;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.requestDTO.RegisterUserDTO;
import com.zepto.zepto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public AppUser createUser(@RequestBody RegisterUserDTO user){
        AppUser response=userService.createUser(user);
        return response;
    }
}
