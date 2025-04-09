package com.zepto.db.controller;

import com.zepto.db.model.AppOrder;
import com.zepto.db.model.AppUser;
import com.zepto.db.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUserController {
    private AppUserRepository appUserRepository;
    @Autowired
    public AppUserController(AppUserRepository appUserRepository){
        this.appUserRepository=appUserRepository;
    }

    @PostMapping("/save")
    public AppUser saveUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return user;
    }

    @GetMapping("/{userId}")
    public AppUser getUserById(@PathVariable UUID userId){
        return appUserRepository.findById(userId).orElse(null);
    }

    @PutMapping("/update")
    public AppUser updateUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return user;
    }

    @DeleteMapping
    public void deleteUser(@PathVariable UUID userId){
        appUserRepository.deleteById(userId);
    }
}
