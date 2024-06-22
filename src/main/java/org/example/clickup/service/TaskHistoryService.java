package org.example.clickup.service;

import org.example.clickup.dto.TaskHistoryDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskHistory;
import org.example.clickup.repository.TaskHistoryRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TaskHistoryService {
    @Autowired
    TaskHistoryRepository taskHistoryRepository;
    @Autowired
    TaskRepository taskRepository;

    public List<TaskHistory> getAllTaskHistory(){
        return taskHistoryRepository.findAll();
    }

    public Result createTaskHistory(TaskHistoryDto taskHistoryDto){
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setChangeFieldName(taskHistoryDto.getChangeFieldName());
        Optional<Task> optionalTask = taskRepository.findById(taskHistoryDto.getTaskId());
        Task task = optionalTask.get();
        taskHistory.setTaskId(task);
        taskHistoryRepository.save(taskHistory);
        return new Result(true,"TaskHistory Created Successfully");
    }

    public Result updatedTaskHistory(TaskHistoryDto taskHistoryDto,Long id){
        Optional<TaskHistory> optionalTaskHistory = taskHistoryRepository.findById(id);
        if(optionalTaskHistory.isPresent()){
            TaskHistory taskHistory = optionalTaskHistory.get();
            taskHistory.setChangeFieldName(taskHistoryDto.getChangeFieldName());
            Optional<Task> optionalTask = taskRepository.findById(taskHistoryDto.getTaskId());
            Task task = optionalTask.get();
            taskHistory.setTaskId(task);
            taskHistoryRepository.save(taskHistory);
            return new Result(true,"TaskHistory Updated Successfully");
        }
        return new Result(false,"TaskHistory Not Found");
    }

    public Result deleteTaskHistory(Long id){
        taskHistoryRepository.deleteById(id);
        return new Result(true,"TaskHistory Deleted Successfully");
    }
}