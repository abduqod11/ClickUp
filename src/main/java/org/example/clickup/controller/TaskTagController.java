package org.example.clickup.controller;

import org.example.clickup.dto.TaskTagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskTag;
import org.example.clickup.service.TaskTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/TaskTag")

public class TaskTagController {
    @Autowired
    TaskTagService taskTagService;

    @GetMapping()
    public List<TaskTag> getAllTaskTag(){
        return taskTagService.getAllTaskTags();
    }

    @PostMapping()
    public Result addTaskTag(@RequestBody TaskTagDto taskTagDto){
        return taskTagService.createTaskTag(taskTagDto);
    }

    @PutMapping()
    public Result updateTaskTag(@RequestBody TaskTagDto taskTagDto,@PathVariable Long id){
        return taskTagService.updateTaskTag(taskTagDto,id);
    }

    @DeleteMapping()
    public Result deleteTaskTag(@PathVariable Long id){
        return taskTagService.deleteTaskTag(id);
    }
}