package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpace;
import org.example.clickup.service.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")

public class WorkSpaceController {
    @Autowired
    WorkSpaceService workSpaceService;

    @GetMapping()
    public List<WorkSpace> getAllWorkSpaces(){
        return workSpaceService.getAllWorkSpaces();
    }

    @GetMapping("/{id}")
    public WorkSpace getWorkSpaceById(@PathVariable Long id){
        return workSpaceService.getWorkSpaceById(id);
    }

    @PostMapping()
    public Result add(@RequestBody WorkSpaceDto workSpaceDto){
        return workSpaceService.createWorkSpace(workSpaceDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkSpace(@PathVariable Long id,@RequestBody WorkSpaceDto workSpaceDto){
        return workSpaceService.updateWorkSpace(workSpaceDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkSpaceById(@PathVariable Long id){
        return workSpaceService.deleteWorkSpaceById(id);
    }
}
