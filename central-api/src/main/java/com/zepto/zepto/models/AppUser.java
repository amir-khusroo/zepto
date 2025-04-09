package com.zepto.zepto.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AppUser {
    UUID id;
    String name;
    String email;
    String password;
    String phoneNumber;
    String userType;
    String pincode;
    String address;
    String status;
}
