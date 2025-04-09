package com.zepto.db.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class AppOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDateTime placedTime;
    int totalAmount;

    @ManyToOne
    AppUser customer;
    @ManyToOne
    AppUser delhiveryPartner;
    @OneToMany
    List<Product> products;

}
