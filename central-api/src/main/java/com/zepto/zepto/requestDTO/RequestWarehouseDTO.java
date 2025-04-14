package com.zepto.zepto.requestDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestWarehouseDTO {
    String name;
    String address;
    String email;
    String pincode;
    UUID managerId;
}
