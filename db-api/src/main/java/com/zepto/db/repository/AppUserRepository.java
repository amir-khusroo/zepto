package com.zepto.db.repository;

import com.zepto.db.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    AppUser findByEmail(String userEmail);

    @Query(value = "select * from app_user where userType='DELIVERY_PARTNER' and pincode=:pincode", nativeQuery = true)
    List<AppUser> getDeliveryPartnerByPincode(String pincode);
}
