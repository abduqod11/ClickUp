package org.example.clickup.service;

import org.example.clickup.dto.TaskTagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskTag;
import org.example.clickup.repository.TagRepository;
import org.example.clickup.repository.TaskRepository;
import org.example.clickup.repository.TaskTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TaskTagService {
    @Autowired
    TaskTagRepository taskTagRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TagRepository tagRepository;

    public List<TaskTag> getAllTaskTags() {
        return taskTagRepository.findAll();
    }

    public Result createTaskTag(TaskTagDto taskTagDto) {
        TaskTag taskTag = new TaskTag();
        Optional<Task> optionalTask = taskRepository.findById(taskTagDto.getTaskId());
        Task task = optionalTask.get();
        taskTag.setTaskId(task);
        Optional<Tag> optionalTag = tagRepository.findById(taskTagDto.getTagId());
        Tag tag = optionalTag.get();
        taskTag.setTagId(tag);
        taskTagRepository.save(taskTag);
        return new Result(true,"TaskTag Created Successfully");
    }

    public Result updateTaskTag(TaskTagDto taskTagDto,Long id) {
        Optional<TaskTag> optionalTaskTag = taskTagRepository.findById(id);
        if(optionalTaskTag.isPresent()) {
            TaskTag taskTag = optionalTaskTag.get();
            Optional<Task> optionalTask = taskRepository.findById(taskTagDto.getTaskId());
            Task task = optionalTask.get();
            taskTag.setTaskId(task);
            Optional<Tag> optionalTag = tagRepository.findById(taskTagDto.getTagId());
            Tag tag = optionalTag.get();
            taskTag.setTagId(tag);
            taskTagRepository.save(taskTag);
            return new Result(true,"TaskTag Updated Successfully");
        }
        return new Result(false,"TaskTag Not Found");
    }

    public Result deleteTaskTag(Long id) {
        taskTagRepository.deleteById(id);
        return new Result(true,"TaskTag Deleted Successfully");
    }
}