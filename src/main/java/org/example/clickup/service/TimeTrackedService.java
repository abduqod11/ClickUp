package org.example.clickup.service;

import org.example.clickup.dto.TimeTrackedDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TimeTracked;
import org.example.clickup.repository.TaskRepository;
import org.example.clickup.repository.TimeTrackedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class TimeTrackedService {
    @Autowired
    TimeTrackedRepository timeTrackedRepository;
    @Autowired
    TaskRepository taskRepository;

    public List<TimeTracked> getAllTimeTracked(){
        return timeTrackedRepository.findAll();
    }

    public Result createTimeTracked(TimeTrackedDto timeTrackedDto){
        TimeTracked timeTracked = new TimeTracked();
        Optional<Task> optionalTask = taskRepository.findById(timeTrackedDto.getTaskId());
        Task task = optionalTask.get();
        timeTracked.setTaskId(task);
        timeTrackedRepository.save(timeTracked);
        return new Result(true,"TimeTracked Created Successfully");
    }

    public Result updateTimeTracked(TimeTrackedDto timeTrackedDto,Long id){
        Optional<TimeTracked> optionalTimeTracked = timeTrackedRepository.findById(id);
        if(optionalTimeTracked.isPresent()){
            TimeTracked timeTracked = optionalTimeTracked.get();
            Optional<Task> optionalTask = taskRepository.findById(timeTrackedDto.getTaskId());
            Task task = optionalTask.get();
            timeTracked.setTaskId(task);
            timeTrackedRepository.save(timeTracked);
            return new Result(true,"TimeTracked Updated Successfully");
        }
        return new Result(false,"TimeTarcked Not Found");
    }

    public Result deleteTimeTracked(Long id){
        timeTrackedRepository.deleteById(id);
        return new Result(true,"TimeTracked Deleted Successfully");
    }
}