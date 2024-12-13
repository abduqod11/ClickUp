package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpaceUser;
import org.example.clickup.service.WorkSpaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/WorkSpaceUser")

public class WorkSpaceUserController {
    @Autowired
    WorkSpaceUserService workSpaceUserService;

    @GetMapping()
    public List<WorkSpaceUser> getWorkSpaceUsers() {
        return workSpaceUserService.getAllWorkSpaceUsers();
    }

    @PostMapping()
    public Result createWorkSpaceUser(@RequestBody WorkSpaceUserDto workSpaceUserDto) {
        return workSpaceUserService.createWorkSpaceUser(workSpaceUserDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkSpaceUser(@RequestBody WorkSpaceUserDto workSpaceUserDto,@PathVariable Long id) {
        return workSpaceUserService.updateWorkSpaceUser(workSpaceUserDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkSpaceUser(@PathVariable Long id) {
        return workSpaceUserService.deleteWorkSpaceUser(id);
    }
}