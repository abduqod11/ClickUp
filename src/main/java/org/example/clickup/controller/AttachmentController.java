package org.example.clickup.controller;

import org.example.clickup.dto.AttachmentDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attachment")

public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping()
    public List<Attachment> getAttachments(){
        return attachmentService.getAllAttachments();
    }

    @PostMapping()
    public Result create(@RequestBody AttachmentDto attachmentDto){
        return attachmentService.createAttachment(attachmentDto);
    }

    @PutMapping("/{id}")
    public Result editAttachmentById(@RequestBody AttachmentDto attachmentDto, @PathVariable Long id){
        return attachmentService.updateAttachment(id,attachmentDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteAttachmentById(@PathVariable Long id){
        return attachmentService.deleteAttachmentById(id);
    }
}