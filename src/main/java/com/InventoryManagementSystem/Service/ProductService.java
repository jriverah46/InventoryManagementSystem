package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.CategoryEntity;
import com.InventoryManagementSystem.Entity.ProductEntity;
import com.InventoryManagementSystem.Entity.SupplierEntity;
import com.InventoryManagementSystem.DTO.ProductDtoRequest;
import com.InventoryManagementSystem.Repository.CategoryRepository;
import com.InventoryManagementSystem.Repository.ProductRepository;
import com.InventoryManagementSystem.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public Optional<ProductEntity> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Optional<ProductEntity>getProductByName(String name){
        return productRepository.findByName(name);
    }

    public ProductEntity createNewProduct(ProductDtoRequest request){
        CategoryEntity category=categoryRepository.findById(request.getCategory())
                .orElseThrow(()->new RuntimeException("Category not found"));
        SupplierEntity supplier = supplierRepository.findById(request.getSupplier())
                .orElseThrow(() -> new RuntimeException("supplier not found"));

        ProductEntity product1=new ProductEntity();
        product1.setName(request.getName());
        product1.setStock(request.getStock());
        product1.setPrice(request.getPrice());
        product1.setDescription(request.getDescription());
        product1.setCategory(category);
        product1.setSupplier(supplier);

        return productRepository.save(product1);
    }

    public List<ProductEntity>getProductsOrderedByPrice(){
        return productRepository.findAllByOrderByPriceAsc();
    }

    public List<ProductEntity>getProductByCategory(Long categoryId){
        CategoryEntity category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new RuntimeException("category not found"));
        return productRepository.findByCategory(category);
    }

    public List<ProductEntity>getProductByLowStock(){
        List<ProductEntity>scarceProducts=productRepository.findByStockLessThan(30);
        return scarceProducts;
    }

    public ProductEntity updateProduct(Long id, ProductDtoRequest request) {
        ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id: " + id));

        CategoryEntity category = categoryRepository.findById(request.getCategory())
                .orElseThrow(() -> new RuntimeException("category not found"));

        SupplierEntity supplier = supplierRepository.findById(request.getSupplier())
                .orElseThrow(() -> new RuntimeException("supplier not found"));

        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setCategory(category);
        existingProduct.setSupplier(supplier);

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

}
