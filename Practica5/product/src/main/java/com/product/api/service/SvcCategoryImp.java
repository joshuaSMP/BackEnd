package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;

@Service
public class SvcCategoryImp implements SvcCategory {

    @Autowired
    RepoCategory repo;

    @Override
    public List<Category> getCategories() {
        return repo.findAll();
    }

    @Override
    public Category getCategoryId(Integer categoryId) {
        Category category = repo.findByCategoryId(categoryId);
        if (category == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "region does not exist");
        }else{
            return category;
        }
    }

    @Override
    public ApiResponse createCategory(Category category) {
        Category categorySaved = (Category) repo.findByCategoryId(category.getCategoryId());
        if(categorySaved != null){
            if(categorySaved.getStatus() == 0){
                repo.activateCategory(categorySaved.getCategoryId());
                return new ApiResponse("category has been activated");
            } else {
                throw new ApiException(HttpStatus.BAD_REQUEST, "category already exists");
            }
        }
        repo.createCategory(category.getCategory(), category.getAcronym());;
        return new ApiResponse("category created");
    }

    @Override
    public ApiResponse updateCategory(Category category) {
        Category categorySaved = (Category) repo.findByCategoryId(category.getCategoryId());
        if(categorySaved != null)
            throw new ApiException(HttpStatus.NOT_FOUND,"category does not exist");
        else{
            if(categorySaved.getStatus() == 0)
                throw new ApiException(HttpStatus.BAD_REQUEST, "category is not active");
            else { 
                categorySaved = (Category) repo.findByCategory(category.getCategory());
                if(categorySaved != null){
                    throw new ApiException(HttpStatus.BAD_REQUEST,"category already exists");
                }
                repo.updateCategory(category.getCategoryId(),category.getCategory(), category.getAcronym());
                return new ApiResponse("category updated");
            }
        }
    }

    @Override
    public ApiResponse deleteByCategoryId(Integer categoryId) {
        Category categorySaved = (Category) repo.findByCategoryId(categoryId);
        if(categorySaved == null){
            throw new ApiException(HttpStatus.NOT_FOUND,"category does not exist");
        }
        repo.deleteByCategoryId(categoryId);
        return new ApiResponse("category removed");
    }
    
}
