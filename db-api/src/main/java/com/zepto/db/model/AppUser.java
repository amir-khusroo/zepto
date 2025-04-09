package com.zepto.db.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String name;
    @Column(unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @Column(unique = true)
    String phoneNumber;
    String userType;
    String pincode;
    String address;
    String status;

}
