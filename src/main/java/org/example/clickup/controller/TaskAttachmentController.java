package org.example.clickup.controller;

import org.example.clickup.dto.TaskAttachmentDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskAttachment;
import org.example.clickup.service.TaskAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/TaskAttachment")

public class TaskAttachmentController {
    @Autowired
    TaskAttachmentService taskAttachmentService;

    @GetMapping()
    public List<TaskAttachment> getAllTaskAttachment(){
        return taskAttachmentService.getAllTaskAttachment();
    }

    @PostMapping()
    public Result addTaskAttachment(@RequestBody TaskAttachmentDto taskAttachmentDto){
        return taskAttachmentService.createTaskAttachment(taskAttachmentDto);
    }

    @PutMapping("/{id}")
    public Result editTaskAttachment(@RequestBody TaskAttachmentDto taskAttachmentDto,@PathVariable Long id){
        return taskAttachmentService.updateTaskAttachment(taskAttachmentDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskAttachment(@PathVariable Long id){
        return taskAttachmentService.deleteTaskAttachment(id);
    }
}