package org.example.clickup.controller;

import org.example.clickup.dto.CategoryDto;
import org.example.clickup.model.Category;
import org.example.clickup.model.Result;
import org.example.clickup.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Category")

public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping()
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public Result editCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long id){
        return categoryService.updateCategory(categoryDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}