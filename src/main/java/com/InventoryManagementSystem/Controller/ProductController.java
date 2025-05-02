package com.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.Entity.ProductEntity;
import com.InventoryManagementSystem.DTO.ProductDtoRequest;
import com.InventoryManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductEntity>> getProductsById(@PathVariable Long id){
        Optional<ProductEntity> product=productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Optional<ProductEntity>> getProductsByName(@PathVariable String name){
        Optional<ProductEntity> product=productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/byPrice")
    public ResponseEntity<List<ProductEntity>>getProductsOrderedByPrice(){
        List<ProductEntity>productsOrderedByPrice=productService.getProductsOrderedByPrice();
        return ResponseEntity.ok(productsOrderedByPrice);
    }
    @GetMapping("/byCategory")
    public ResponseEntity<List<ProductEntity>> getProductByCategory(Long categoryId){
        List<ProductEntity>productsByCategory=productService.getProductByCategory(categoryId);
        return ResponseEntity.ok(productsByCategory);
    }
    @GetMapping("lowStock")
    public ResponseEntity<List<ProductEntity>>getProductByLowStock(){
        return ResponseEntity.ok(productService.getProductByLowStock());
    }
    @PostMapping("/createProduct")
    public ResponseEntity<ProductEntity>createProduct(@RequestBody ProductDtoRequest request){
        ProductEntity product=productService.createNewProduct(request);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductDtoRequest request) {
        ProductEntity updatedProduct = productService.updateProduct(id, request);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }




}
