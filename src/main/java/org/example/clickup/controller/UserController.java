package org.example.clickup.controller;

import org.example.clickup.dto.UserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping()
    public Result createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id){
        return userService.deleteUserById(id);
    }
}