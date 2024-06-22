package org.example.clickup.service;

import org.example.clickup.dto.TaskDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.PriorityRepository;
import org.example.clickup.repository.StatusRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PriorityRepository priorityRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Result createTask(TaskDto taskDto){
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setParentTaskId(taskDto.getParentTaskId());
        task.setEstimateTime(taskDto.getEstimateTime());
        Optional<Status> optionalStatus = statusRepository.findById(taskDto.getStatusId());
        Status status = optionalStatus.get();
        task.setStatusId(status);
        Optional<Category> optionalCategory = categoryRepository.findById(taskDto.getCategoryId());
        Category category = optionalCategory.get();
        task.setCategoryId(category);
        Optional<Priority> optionalPriority = priorityRepository.findById(taskDto.getPriorityId());
        Priority priority = optionalPriority.get();
        task.setPriorityId(priority);
        taskRepository.save(task);
        return new Result(true,"Task Created Successfully");
    }

    public Result updateTask(TaskDto taskDto,Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            task.setParentTaskId(taskDto.getParentTaskId());
            task.setEstimateTime(taskDto.getEstimateTime());
            Optional<Status> optionalStatus = statusRepository.findById(taskDto.getStatusId());
            Status status = optionalStatus.get();
            task.setStatusId(status);
            Optional<Category> optionalCategory = categoryRepository.findById(taskDto.getCategoryId());
            Category category = optionalCategory.get();
            task.setCategoryId(category);
            Optional<Priority> optionalPriority = priorityRepository.findById(taskDto.getPriorityId());
            Priority priority = optionalPriority.get();
            task.setPriorityId(priority);
            taskRepository.save(task);
            return new Result(true,"Task Updated Successfully");
        }
        return new Result(false,"Task Not Found");
    }

    public Result deleteTask(Long id){
        taskRepository.deleteById(id);
        return new Result(true,"Task Deleted Successfully");
    }
}