package com.InventoryManagementSystem.Repository;

import com.InventoryManagementSystem.Entity.CategoryEntity;
import com.InventoryManagementSystem.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findById(Long id);
    Optional<ProductEntity> findByName(String name);
    List<ProductEntity> findAllByOrderByPriceAsc();

    List<ProductEntity>findByCategory(CategoryEntity category);

    List<ProductEntity>findByStockLessThan(Integer stockAvailable);
}
