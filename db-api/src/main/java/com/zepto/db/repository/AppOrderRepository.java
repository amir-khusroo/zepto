package com.zepto.db.repository;

import com.zepto.db.model.AppOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppOrderRepository extends JpaRepository<AppOrder, UUID> {
}
