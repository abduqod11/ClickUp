package org.example.clickup.controller;

import org.example.clickup.dto.TaskDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Task")

public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping()
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping()
    public Result addTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @PutMapping()
    public Result updateTask(@RequestBody TaskDto taskDto,@PathVariable Long id) {
        return taskService.updateTask(taskDto,id);
    }

    @DeleteMapping()
    public Result deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }
}