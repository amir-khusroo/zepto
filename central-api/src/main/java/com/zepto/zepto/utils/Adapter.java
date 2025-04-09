package com.zepto.zepto.utils;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.requestDTO.RegisterUserDTO;
import org.springframework.stereotype.Component;

@Component
public class Adapter {
    public AppUser mapUserRequestBodyToAppUser(RegisterUserDTO user){
        AppUser appUser=AppUser.builder()
                .name(user.getName())
                .userType(user.getUserType().toString())
                .email(user.getEmail())
                .address((user.getAddress()))
                .pincode(user.getPincode())
                .status("ACTIVE")
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return appUser;
    }
}
