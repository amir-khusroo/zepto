package com.zepto.db.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String address;
    @Column(unique = true, nullable = false)
    String email;
    String pincode;
    @OneToOne
    AppUser manager;

}
