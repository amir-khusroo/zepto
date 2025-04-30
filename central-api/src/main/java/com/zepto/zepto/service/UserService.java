package com.zepto.zepto.service;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.requestDTO.RegisterUserDTO;
import com.zepto.zepto.utils.Adapter;
import com.zepto.zepto.utils.DatabaseAPIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    DatabaseAPIUtil databaseAPIUtil;
    @Autowired
    Adapter adapter;

    public AppUser createUser(RegisterUserDTO user){
        AppUser appUser=adapter.mapUserRequestBodyToAppUser(user);

        AppUser response= databaseAPIUtil.callCreateUserEndpoints(appUser);
        return response;
    }

    public List<AppUser> getDelhiveryPartnerByPincode(String pincode){
        return databaseAPIUtil.getDelhiveryPartnerByPincode(pincode);
    }
}
