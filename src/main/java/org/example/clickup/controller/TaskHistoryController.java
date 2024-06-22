package org.example.clickup.controller;

import org.example.clickup.dto.TaskHistoryDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskHistory;
import org.example.clickup.service.TaskHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/TaskHistory")

public class TaskHistoryController {
    @Autowired
    TaskHistoryService taskHistoryService;

    public List<TaskHistory> getAllTaskHistory(){
        return taskHistoryService.getAllTaskHistory();
    }

    public Result addTaskHistory(@RequestBody TaskHistoryDto taskHistoryDto){
        return taskHistoryService.createTaskHistory(taskHistoryDto);
    }

    public Result editTaskHistory(@RequestBody TaskHistoryDto taskHistoryDto,@PathVariable Long id){
        return taskHistoryService.updatedTaskHistory(taskHistoryDto,id);
    }

    public Result deleteTaskHistory(@PathVariable Long id){
        return taskHistoryService.deleteTaskHistory(id);
    }
}