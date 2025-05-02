package com.InventoryManagementSystem.DTO;

import com.InventoryManagementSystem.Entity.CategoryEntity;
import com.InventoryManagementSystem.Entity.SupplierEntity;
import lombok.Data;

@Data
public class ProductDtoRequest {
    private String name;
    private String Description;
    private Double price;
    private Integer stock;
    private Long category;
    private Long supplier;

}
