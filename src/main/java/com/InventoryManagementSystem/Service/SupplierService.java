package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.SupplierEntity;
import com.InventoryManagementSystem.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierEntity getSupplierById(Long id){
        return supplierRepository.findById(id).orElseThrow(()->new RuntimeException("supplier not found"));
    }

    public List<SupplierEntity> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public SupplierEntity createSupplier(SupplierEntity supplier) {
        return supplierRepository.save(supplier);
    }
    public SupplierEntity updateSupplier(Long id, SupplierEntity updatedSupplier) {
        SupplierEntity existing = getSupplierById(id);
        existing.setName(updatedSupplier.getName());
        existing.setPhoneNumber(updatedSupplier.getPhoneNumber());
        existing.setEmail(updatedSupplier.getEmail());
        return supplierRepository.save(existing);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }



}
