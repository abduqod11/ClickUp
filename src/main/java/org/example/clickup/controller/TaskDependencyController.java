package org.example.clickup.controller;

import org.example.clickup.dto.TaskDependencyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskDependency;
import org.example.clickup.service.TaskDependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/TaskDependency")

public class TaskDependencyController {
    @Autowired
    TaskDependencyService taskDependencyService;

    public List<TaskDependency> getAllTaskDependency(){
        return taskDependencyService.getAllTaskDependency();
    }

    public Result addTaskDependency(@RequestBody TaskDependencyDto taskDependencyDto){
        return taskDependencyService.createTaskDependency(taskDependencyDto);
    }

    public Result editTaskDependency(@RequestBody TaskDependencyDto taskDependencyDto,@PathVariable Long id){
        return taskDependencyService.updateTaskDependency(taskDependencyDto,id);
    }

    public Result deleteTaskDependency(@PathVariable Long id){
        return taskDependencyService.deleteTaskDependency(id);
    }
}