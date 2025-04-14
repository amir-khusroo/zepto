package com.zepto.zepto.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WareHouse {
    UUID id;
    String name;
    String address;
    String email;
    String pincode;
    AppUser manager;
}
