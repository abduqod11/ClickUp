package org.example.clickup.controller;

import org.example.clickup.dto.PriorityDto;
import org.example.clickup.model.Priority;
import org.example.clickup.model.Result;
import org.example.clickup.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Priority")

public class PriorityController {
    @Autowired
    PriorityService priorityService;

    @GetMapping()
    public List<Priority> getAllPriority(){
        return priorityService.getAllPriority();
    }

    @PostMapping()
    public Result addPriority(@RequestBody PriorityDto priorityDto){
        return priorityService.createPriority(priorityDto);
    }

    @PutMapping()
    public Result editPriority(@RequestBody PriorityDto priorityDto,@PathVariable Long id){
        return priorityService.updatePriority(priorityDto,id);
    }

    @DeleteMapping()
    public Result deletePriority(@PathVariable Long id){
        return priorityService.deletePriority(id);
    }
}