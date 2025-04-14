package com.zepto.zepto.requestDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterWareHouseProductDTO {
    UUID wid;
    UUID pid;
    int discount;
    int totalQuantity;
}
