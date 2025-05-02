package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.DTO.CategoryRequestDto;
import com.InventoryManagementSystem.DTO.CategoryResponseDto;
import com.InventoryManagementSystem.Entity.CategoryEntity;
import com.InventoryManagementSystem.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public CategoryResponseDto createNewCategory(CategoryRequestDto requestDto){
        CategoryEntity category=new CategoryEntity();
        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());

        return toResponseDto(category);
    }
    public CategoryResponseDto findCategoryById(Long id){
        CategoryEntity category=categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("category not found"));

        return toResponseDto(category);
    }

    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }


    public CategoryResponseDto toResponseDto(CategoryEntity category){
        CategoryResponseDto categoryResponseDto=new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        categoryResponseDto.setDescription(category.getDescription());

        return categoryResponseDto;
    }

}
