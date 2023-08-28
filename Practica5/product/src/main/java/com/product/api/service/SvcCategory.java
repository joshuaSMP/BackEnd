package com.product.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Category;

public interface SvcCategory {
    
    List<Category> getCategories();
    
    Category getCategoryId(Integer categoryId);

    ApiResponse createCategory(Category category);

    ApiResponse updateCategory(Category category);

    ApiResponse deleteByCategoryId(Integer categoryId);

}
