package com.zepto.zepto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    UUID id;
    String name;
    String address;
    String email;
    String pincode;
    AppUser manager;
}
