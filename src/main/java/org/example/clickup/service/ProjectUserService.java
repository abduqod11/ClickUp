package org.example.clickup.service;

import org.example.clickup.dto.ProjectUserDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.ProjectUser;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.ProjectRepository;
import org.example.clickup.repository.ProjectUserRepository;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ProjectUserService {
    @Autowired
    ProjectUserRepository projectUserRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    public List<ProjectUser> getAllProjectUser(){
        return projectUserRepository.findAll();
    }

    public Result createProjectUser(ProjectUserDto projectUserDto){
        ProjectUser projectUser = new ProjectUser();
        Optional<Project> optionalProject = projectRepository.findById(projectUserDto.getProjectId());
        Project project = optionalProject.get();
        projectUser.setProjectId(project);
        Optional<User> optionalUser = userRepository.findById(projectUserDto.getUserId());
        User user = optionalUser.get();
        projectUser.setUserId(user);
        projectUserRepository.save(projectUser);
        return new Result(true,"ProjectUser Created Successfully");
    }

    public Result updateProjectUser(ProjectUserDto projectUserDto,Long id){
        Optional<ProjectUser> optionalProjectUser = projectUserRepository.findById(id);
        if(optionalProjectUser.isPresent()){
            ProjectUser projectUser = optionalProjectUser.get();
            Optional<Project> optionalProject = projectRepository.findById(projectUserDto.getProjectId());
            Project project = optionalProject.get();
            projectUser.setProjectId(project);
            Optional<User> optionalUser = userRepository.findById(projectUserDto.getUserId());
            User user = optionalUser.get();
            projectUser.setUserId(user);
            projectUserRepository.save(projectUser);
            return new Result(true,"ProjectUser Updated Successfully");
        }
        return new Result(false,"ProjectUser Not Found");
    }

    public Result deleteProjectUser(Long id){
        projectUserRepository.deleteById(id);
        return new Result(true,"ProjectUser Deleted Successfully");
    }
}