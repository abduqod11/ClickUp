package org.example.clickup.controller;

import org.example.clickup.dto.ProjectDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Project")

public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping()
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping()
    public Result addProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

    @PutMapping()
    public Result updateProject(@RequestBody ProjectDto projectDto,@PathVariable Long id) {
        return projectService.updateProject(projectDto, id);
    }

    @DeleteMapping()
    public Result deleteProject(@PathVariable Long id) {
        return projectService.deleteProject(id);
    }
}