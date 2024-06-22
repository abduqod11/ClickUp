package org.example.clickup.service;

import org.example.clickup.dto.TaskDependencyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskDependency;
import org.example.clickup.repository.TaskDependencyRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TaskDependencyService {
    @Autowired
    TaskDependencyRepository taskDependencyRepository;
    @Autowired
    TaskRepository taskRepository;

    public List<TaskDependency> getAllTaskDependency(){
        return taskDependencyRepository.findAll();
    }

    public Result createTaskDependency(TaskDependencyDto taskDependencyDto){
        TaskDependency taskDependency = new TaskDependency();
        taskDependency.setDependencyTaskId(taskDependencyDto.getDependencyTaskId());
        Optional<Task> optionalTask = taskRepository.findById(taskDependencyDto.getTaskId());
        Task task = optionalTask.get();
        taskDependency.setTaskId(task);
        taskDependencyRepository.save(taskDependency);
        return new Result(true,"TaskDependency Created Successfully");
    }

    public Result updateTaskDependency(TaskDependencyDto taskDependencyDto,Long id){
        Optional<TaskDependency> optionalTaskDependency = taskDependencyRepository.findById(id);
        if(optionalTaskDependency.isPresent()){
            TaskDependency taskDependency = optionalTaskDependency.get();
            taskDependency.setDependencyTaskId(taskDependencyDto.getDependencyTaskId());
            Optional<Task> optionalTask = taskRepository.findById(taskDependencyDto.getTaskId());
            Task task = optionalTask.get();
            taskDependency.setTaskId(task);
            taskDependencyRepository.save(taskDependency);
            return new Result(true,"TaskDependency Updated Successfully");
        }
        return new Result(false,"TaskDependency Not Found");
    }

    public Result deleteTaskDependency(Long id){
        taskDependencyRepository.deleteById(id);
        return new Result(true,"TaskDependency Deleted Successfully");
    }
}
