package com.zepto.zepto.service;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.requestDTO.RegisterUserDTO;
import com.zepto.zepto.utils.Adapter;
import com.zepto.zepto.utils.DatabaseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    DatabaseAPI databaseAPI;
    @Autowired
    Adapter adapter;

    public AppUser createUser(RegisterUserDTO user){
        AppUser appUser=adapter.mapUserRequestBodyToAppUser(user);

        AppUser response=databaseAPI.callCreateUserEndpoints(appUser);
        return response;
    }
}
