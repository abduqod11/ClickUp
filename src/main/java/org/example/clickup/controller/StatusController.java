package org.example.clickup.controller;

import org.example.clickup.dto.StatusDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Status;
import org.example.clickup.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Status")

public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping()
    public List<Status> getAllStatus(){
        return statusService.getAllStatus();
    }

    @PostMapping()
    public Result addStatus(@RequestBody StatusDto statusDto){
        return statusService.createStatus(statusDto);
    }

    @PutMapping("/{id}")
    public Result editStatus(@RequestBody StatusDto statusDto,@PathVariable Long id){
        return statusService.updateStatus(statusDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteStatus(@PathVariable Long id) {
        return statusService.deleteStatus(id);
    }
}