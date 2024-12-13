package org.example.clickup.controller;

import org.example.clickup.dto.TaskHistoryDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskHistory;
import org.example.clickup.service.TaskHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/TaskHistory")

public class TaskHistoryController {
    @Autowired
    TaskHistoryService taskHistoryService;

    @GetMapping()
    public List<TaskHistory> getAllTaskHistory(){
        return taskHistoryService.getAllTaskHistory();
    }

    @PostMapping()
    public Result addTaskHistory(@RequestBody TaskHistoryDto taskHistoryDto){
        return taskHistoryService.createTaskHistory(taskHistoryDto);
    }

    @PutMapping("/{id}")
    public Result editTaskHistory(@RequestBody TaskHistoryDto taskHistoryDto,@PathVariable Long id){
        return taskHistoryService.updatedTaskHistory(taskHistoryDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskHistory(@PathVariable Long id){
        return taskHistoryService.deleteTaskHistory(id);
    }
}