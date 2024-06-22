package org.example.clickup.controller;

import org.example.clickup.dto.TaskUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskUser;
import org.example.clickup.service.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/TaskUser")

public class TaskUserController {
    @Autowired
    TaskUserService taskUserService;

    @GetMapping()
    public List<TaskUser> getTaskUsers() {
        return taskUserService.getAllTaskUsers();
    }

    @PostMapping()
    public Result addTaskUser(@RequestBody TaskUserDto taskUserDto) {
        return taskUserService.createTaskUser(taskUserDto);
    }

    @PutMapping()
    public Result updateTaskUser(@RequestBody TaskUserDto taskUserDto,@PathVariable Long id) {
        return taskUserService.updateTaskUser(taskUserDto,id);
    }

    @DeleteMapping()
    public Result deleteTaskUser(@PathVariable Long id) {
        return taskUserService.deleteTaskUser(id);
    }
}