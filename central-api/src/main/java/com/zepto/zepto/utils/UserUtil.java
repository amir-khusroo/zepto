package com.zepto.zepto.utils;

import com.zepto.zepto.enums.UserType;
import com.zepto.zepto.models.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {
    public boolean isZeptoApplicationAdmin(AppUser user){
        if(user==null){
            throw new RuntimeException("User does not exist");
        }
        return user.getUserType().equals(UserType.APPLICATION_ADMIN.toString());
    }

    public boolean isZeptoWareHouseManager(AppUser user){
        if(user==null){
            throw new RuntimeException("User does not exist");
        }
        return user.getUserType().equals(UserType.WAREHOUSE_MANAGER.toString());
    }

}
