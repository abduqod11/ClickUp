package org.example.clickup.service;

import org.example.clickup.dto.TaskAttachmentDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskAttachment;
import org.example.clickup.repository.AttachmentRepository;
import org.example.clickup.repository.TaskAttachmentRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TaskAttachmentService {
    @Autowired
    TaskAttachmentRepository taskAttachmentRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<TaskAttachment> getAllTaskAttachment(){
        return taskAttachmentRepository.findAll();
    }

    public Result createTaskAttachment(TaskAttachmentDto taskAttachmentDto){
        TaskAttachment taskAttachment = new TaskAttachment();
        Optional<Task> optionalTask = taskRepository.findById(taskAttachmentDto.getTaskId());
        Task task = optionalTask.get();
        taskAttachment.setTaskId(task);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(taskAttachmentDto.getAttachmentId());
        Attachment attachment = optionalAttachment.get();
        taskAttachment.setAttachmentId(attachment);
        taskAttachmentRepository.save(taskAttachment);
        return new Result(true,"TaskAttachment Created Successfully");
    }

    public Result updateTaskAttachment(TaskAttachmentDto taskAttachmentDto,Long id){
        Optional<TaskAttachment> optionalTaskAttachment = taskAttachmentRepository.findById(id);
        if(optionalTaskAttachment.isPresent()){
            TaskAttachment taskAttachment = optionalTaskAttachment.get();
            Optional<Task> optionalTask = taskRepository.findById(taskAttachmentDto.getTaskId());
            Task task = optionalTask.get();
            taskAttachment.setTaskId(task);
            Optional<Attachment> optionalAttachment = attachmentRepository.findById(taskAttachmentDto.getAttachmentId());
            Attachment attachment = optionalAttachment.get();
            taskAttachment.setAttachmentId(attachment);
            taskAttachmentRepository.save(taskAttachment);
            return new Result(true,"TaskAttachment Updated Successfully");
        }
        return new Result(false,"TaskAttachment Not Found");
    }

    public Result deleteTaskAttachment(Long id){
        taskAttachmentRepository.deleteById(id);
        return new Result(true,"TaskAttachment Deleted Successfully");
    }
}