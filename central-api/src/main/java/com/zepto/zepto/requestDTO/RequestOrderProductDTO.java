package com.zepto.zepto.requestDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestOrderProductDTO {
    UUID pid;
    int quantity;
}
