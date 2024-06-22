package org.example.clickup.service;

import org.example.clickup.dto.CategoryDto;
import org.example.clickup.dto.CategoryUserDto;
import org.example.clickup.model.CategoryUser;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.CategoryUserRepository;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryUserService {
    @Autowired
    CategoryUserRepository categoryUserRepository;
    @Autowired
    UserRepository userRepository;

    public List<CategoryUser> getAllCategoryUser(){
        return categoryUserRepository.findAll();
    }

    public Result createCategoryUser(CategoryUserDto categoryUserDto){
        CategoryUser categoryUser = new CategoryUser();
        categoryUser.setName(categoryUserDto.getName());
        Optional<User> optionalUser = userRepository.findById(categoryUserDto.getUserId());
        User user = optionalUser.get();
        categoryUser.setUserId(user);
        categoryUserRepository.save(categoryUser);
        return new Result(true,"CategoryUser Created Successfully");
    }

    public Result updateCategoryUser(CategoryUserDto categoryUserDto,Long id){
        Optional<CategoryUser> optionalCategoryUser = categoryUserRepository.findById(id);
        if(optionalCategoryUser.isPresent()){
            CategoryUser categoryUser = optionalCategoryUser.get();
            categoryUser.setName(categoryUserDto.getName());
            Optional<User> optionalUser = userRepository.findById(categoryUserDto.getUserId());
            User user = optionalUser.get();
            categoryUser.setUserId(user);
            categoryUserRepository.save(categoryUser);
            return new Result(true,"CategoryUser Created Successfully");
        }
        return new Result(false,"CategoryUser Not Found");
    }

    public Result deleteCategoryUser(Long id){
        categoryUserRepository.deleteById(id);
        return new Result(true,"CategoryUser Deleted Successfully");
    }
}