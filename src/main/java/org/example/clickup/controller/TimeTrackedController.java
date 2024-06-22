package org.example.clickup.controller;

import org.example.clickup.dto.TimeTrackedDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TimeTracked;
import org.example.clickup.service.TimeTrackedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/TimeTracked")

public class TimeTrackedController {
    @Autowired
    TimeTrackedService timeTrackedService;

    @GetMapping()
    public List<TimeTracked> getAllTimeTracked(){
        return timeTrackedService.getAllTimeTracked();
    }

    @PostMapping()
    public Result addTimeTracked(@RequestBody TimeTrackedDto timeTrackedDto){
        return timeTrackedService.createTimeTracked(timeTrackedDto);
    }

    @PutMapping()
    public Result editTimeTracked(@RequestBody TimeTrackedDto timeTrackedDto,@PathVariable Long id){
        return timeTrackedService.updateTimeTracked(timeTrackedDto,id);
    }

    @DeleteMapping()
    public Result deleteTimeTracked(@PathVariable Long id){
        return timeTrackedService.deleteTimeTracked(id);
    }
}