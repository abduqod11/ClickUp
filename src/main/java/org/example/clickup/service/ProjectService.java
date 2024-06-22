package org.example.clickup.service;

import org.example.clickup.dto.ProjectDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.repository.ProjectRepository;
import org.example.clickup.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SpaceRepository spaceRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Result createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setArchived(project.getArchived());
        project.setColor(project.getColor());
        project.setAccessType(project.getAccessType());
        Optional<Space> optionalSpace = spaceRepository.findById(projectDto.getSpaceId());
        Space space = optionalSpace.get();
        project.setSpaceId(space);
        projectRepository.save(project);
        return new Result(true,"Project Created Successfully");
    }

    public Result updateProject(ProjectDto projectDto,Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setName(projectDto.getName());
            project.setArchived(project.getArchived());
            project.setColor(project.getColor());
            project.setAccessType(project.getAccessType());
            Optional<Space> optionalSpace = spaceRepository.findById(projectDto.getSpaceId());
            Space space = optionalSpace.get();
            project.setSpaceId(space);
            projectRepository.save(project);
            return new Result(true,"Project Updated Successfully");
        }
        return new Result(false,"Project Not Found");
    }

    public Result deleteProject(Long id) {
        projectRepository.deleteById(id);
        return new Result(true,"Project Deleted Successfully");
    }
}