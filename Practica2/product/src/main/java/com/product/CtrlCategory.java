package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class CtrlCategory {
    
    private Category[] categories = {
        new Category(1, "Linea Blanca", "LB"), 
        new Category(2, "Electronica","Electr"),
    };

    @GetMapping("/category")
    public List<Category> getCategories(){
        return Arrays.asList(categories);
    }

}
