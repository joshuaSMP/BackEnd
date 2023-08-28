package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

@RestController
@RequestMapping("/category")
public class CtrlCategory {
    
    // Valores por defecto al iniciar el programa
    private ArrayList<Category> categories = new ArrayList<>(){
        { 
            add(new Category(1, "Abarrotes", "Abarr", 1));
            add(new Category(2, "Electrónica","Electr",1));
        }
    };

    @GetMapping()
    public ResponseEntity<List<Category>> getCategories(){
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Integer> getCategory(
        @PathVariable(value = "categoryId") Integer categoryId){
        return new ResponseEntity<>(categoryId, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createCategory(
        @Valid @RequestBody final Category category,
        BindingResult bindingResult
    ){
        String message = "";
        if(bindingResult.hasErrors()){
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        Category categoryInDB = categories.stream()
                   .filter(c -> c.equals(category))
                   .findFirst()
                   .orElse(null);

        if(categoryInDB != null){
            return new ResponseEntity<>("Category already exists", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Category created", HttpStatus.OK);
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateCategory(
        @Valid @RequestBody Category category,
        BindingResult bindingResult 
    ){
        String message = "";
        if(bindingResult.hasErrors()){
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        
        Category categoryInDB = categories.stream()
                   .filter(c -> c.equals(category))
                   .findFirst()
                   .orElse(null);

        if(categoryInDB != null){
            return new ResponseEntity<>("Category updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category doest not exists", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(
        @PathVariable(value = "categoryId") Integer categoryId
    ){
        Category category = categories
                                .stream()
                                .filter(c -> c.getCategory_id() == categoryId)
                                .findFirst()
                                .orElse(null);
        if(category == null){
            return new ResponseEntity<>("Category does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Category removed", HttpStatus.OK);
    }


}
