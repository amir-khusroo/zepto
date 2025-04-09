package com.zepto.zepto.models;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
