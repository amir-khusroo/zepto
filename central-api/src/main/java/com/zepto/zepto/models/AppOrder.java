package com.zepto.zepto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppOrder {
    UUID id;
    LocalDateTime placedTime;
    AppUser customer;
    AppUser deliveryPartner;
    double totalamount;
    List<Product> products;
}
