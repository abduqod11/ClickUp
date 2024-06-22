package org.example.clickup.service;

import org.example.clickup.dto.TaskUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskUser;
import org.example.clickup.model.User;
import org.example.clickup.repository.TaskRepository;
import org.example.clickup.repository.TaskUserRepository;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TaskUserService {
    @Autowired
    TaskUserRepository taskUserRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    public List<TaskUser> getAllTaskUsers() {
        return taskUserRepository.findAll();
    }

    public Result createTaskUser(TaskUserDto taskUserDto) {
        TaskUser taskUser = new TaskUser();
        Optional<Task> optionalTask = taskRepository.findById(taskUserDto.getTaskId());
        Task task = optionalTask.get();
        taskUser.setTaskId(task);
        Optional<User> optionalUser = userRepository.findById(taskUserDto.getUserId());
        User user = optionalUser.get();
        taskUser.setUserId(user);
        taskUserRepository.save(taskUser);
        return new Result(true,"TaskUser Created Successfully");
    }

    public Result updateTaskUser(TaskUserDto taskUserDto,Long id) {
        Optional<TaskUser> optionalTaskUser = taskUserRepository.findById(id);
        if(optionalTaskUser.isPresent()){
            TaskUser taskUser = optionalTaskUser.get();
            Optional<Task> optionalTask = taskRepository.findById(taskUserDto.getTaskId());
            Task task = optionalTask.get();
            taskUser.setTaskId(task);
            Optional<User> optionalUser = userRepository.findById(taskUserDto.getUserId());
            User user = optionalUser.get();
            taskUser.setUserId(user);
            taskUserRepository.save(taskUser);
            return new Result(true,"TaskUser Updated Successfully");
        }
        return new Result(false,"TaskUser Not Found");
    }

    public Result deleteTaskUser(Long id) {
        taskUserRepository.deleteById(id);
        return new Result(true,"TaskUser Deleted Successfully");
    }
}