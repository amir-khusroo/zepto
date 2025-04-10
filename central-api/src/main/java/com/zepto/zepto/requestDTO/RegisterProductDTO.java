package com.zepto.zepto.requestDTO;

import lombok.Data;

@Data
public class RegisterProductDTO {
    String productName;
    int productPrice;
    String detail;
    String manufacturerEmail;
    Double rating;
    int weight;
    int totalPurchase;
}
