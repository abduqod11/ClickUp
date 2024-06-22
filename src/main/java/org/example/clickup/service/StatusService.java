package org.example.clickup.service;

import org.example.clickup.dto.StatusDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.ProjectRepository;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class StatusService {
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Status> getAllStatus(){
        return statusRepository.findAll();
    }

    public Result createStatus(StatusDto statusDto){
        Status status = new Status();
        status.setName(statusDto.getName());
        status.setName(statusDto.getName());
        Optional<Space> optionalSpace = spaceRepository.findById(statusDto.getSpaceId());
        Space space = optionalSpace.get();
        status.setSpaceId(space);
        Optional<Project> optionalProject = projectRepository.findById(statusDto.getProjectId());
        Project project = optionalProject.get();
        status.setProjectId(project);
        Optional<Category> optionalCategory = categoryRepository.findById(statusDto.getCategoryId());
        Category category = optionalCategory.get();
        status.setCategoryId(category);
        statusRepository.save(status);
        return new Result(true,"Status Created Successfully");
    }

    public Result updateStatus(StatusDto statusDto,Long id){
        Optional<Status> optionalStatus = statusRepository.findById(id);
        if(optionalStatus.isPresent()){
            Status status = optionalStatus.get();
            status.setColor(statusDto.getColor());
            status.setName(statusDto.getName());
            Optional<Space> optionalSpace = spaceRepository.findById(statusDto.getSpaceId());
            Space space = optionalSpace.get();
            status.setSpaceId(space);
            Optional<Project> optionalProject = projectRepository.findById(statusDto.getProjectId());
            Project project = optionalProject.get();
            status.setProjectId(project);
            Optional<Category> optionalCategory = categoryRepository.findById(statusDto.getCategoryId());
            Category category = optionalCategory.get();
            status.setCategoryId(category);
            statusRepository.save(status);
            return new Result(true,"Status Updated Successfully");
        }
        return new Result(false,"Status Not Found");
    }

    public Result deleteStatus(Long id){
        statusRepository.deleteById(id);
        return new Result(true,"Status Deleted Successfully");
    }
}