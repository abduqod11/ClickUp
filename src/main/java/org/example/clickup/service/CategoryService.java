package org.example.clickup.service;

import org.example.clickup.dto.CategoryDto;
import org.example.clickup.model.Category;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Result createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setAccessType(category.getAccessType());
        category.setColor(category.getColor());
        category.setArchived(category.getArchived());
        Optional<Project> optionalProject = projectRepository.findById(categoryDto.getProjectId());
        Project project = optionalProject.get();
        category.setProjectId(project);
        categoryRepository.save(category);
        return new Result(true,"Category Created Successfully");
    }

    public Result updateCategory(CategoryDto categoryDto,Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            category.setAccessType(category.getAccessType());
            category.setColor(category.getColor());
            category.setArchived(category.getArchived());
            Optional<Project> optionalProject = projectRepository.findById(categoryDto.getProjectId());
            Project project = optionalProject.get();
            category.setProjectId(project);
            categoryRepository.save(category);
            return new Result(true,"Category Updated Successfully");
        }
        return new Result(false,"Category Not Found");
    }

    public Result deleteCategory(Long id){
        projectRepository.deleteById(id);
        return new Result(true,"Category Deleted Successfully");
    }
}