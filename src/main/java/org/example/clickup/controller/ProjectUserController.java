package org.example.clickup.controller;

import org.example.clickup.dto.ProjectUserDto;
import org.example.clickup.model.ProjectUser;
import org.example.clickup.model.Result;
import org.example.clickup.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ProjectUser")

public class ProjectUserController {
    @Autowired
    ProjectUserService projectUserService;

    @GetMapping()
    public List<ProjectUser> getALlProjectUser(){
        return projectUserService.getAllProjectUser();
    }

    @PostMapping()
    public Result addProjectUser(@RequestBody ProjectUserDto projectUserDto){
        return projectUserService.createProjectUser(projectUserDto);
    }

    @PutMapping("/{id}")
    public Result editProjectUser(@RequestBody ProjectUserDto projectUserDto,@PathVariable Long id){
        return projectUserService.updateProjectUser(projectUserDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteProjectUser(@PathVariable Long id){
        return projectUserService.deleteProjectUser(id);
    }
}