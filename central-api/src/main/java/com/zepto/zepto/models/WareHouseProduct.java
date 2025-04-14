package com.zepto.zepto.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WareHouseProduct {
    UUID id;
    UUID wid;
    UUID pid;
    int discount;
    int totalQuantity;
}
