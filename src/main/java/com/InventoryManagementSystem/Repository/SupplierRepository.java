package com.InventoryManagementSystem.Repository;

import com.InventoryManagementSystem.Entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {
}
