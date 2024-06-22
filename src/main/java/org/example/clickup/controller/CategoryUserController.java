package org.example.clickup.controller;

import org.example.clickup.dto.CategoryUserDto;
import org.example.clickup.model.CategoryUser;
import org.example.clickup.model.Result;
import org.example.clickup.service.CategoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CategoryUser")

public class CategoryUserController {
    @Autowired
    CategoryUserService categoryUserService;

    @GetMapping()
    public List<CategoryUser> getAllCategoryUser(){
        return categoryUserService.getAllCategoryUser();
    }

    @PostMapping()
    public Result addCategoryUser(@RequestBody CategoryUserDto categoryUserDto){
        return categoryUserService.createCategoryUser(categoryUserDto);
    }

    @PutMapping()
    public Result editCategoryUser(@RequestBody CategoryUserDto categoryUserDto,@PathVariable Long id){
        return categoryUserService.updateCategoryUser(categoryUserDto,id);
    }

    @DeleteMapping()
    public Result deleteCategoryUser(@PathVariable Long id){
        return categoryUserService.deleteCategoryUser(id);
    }
}