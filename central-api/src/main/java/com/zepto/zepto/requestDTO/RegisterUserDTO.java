package com.zepto.zepto.requestDTO;

import com.zepto.zepto.enums.UserType;
import lombok.Data;

@Data
public class RegisterUserDTO {
    String name;
    String email;
    String password;
    String phoneNumber;
    String pincode;
    String address;
    UserType userType;
}
