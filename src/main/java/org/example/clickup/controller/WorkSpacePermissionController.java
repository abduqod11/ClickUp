package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpacePermissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpacePermission;
import org.example.clickup.service.WorkSpacePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/WorkSpacePermission")

public class WorkSpacePermissionController {
    @Autowired
    WorkSpacePermissionService workSpacePermissionService;

    @GetMapping()
    public List<WorkSpacePermission> getWorkSpacePermissions() {
        return workSpacePermissionService.getAllPermissions();
    }

    @PostMapping()
    public Result addWorkSpacePermission(@RequestBody WorkSpacePermissionDto workSpacePermissionDto) {
        return workSpacePermissionService.createWorkSpacePermission(workSpacePermissionDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkSpacePermission(@PathVariable Long id) {
        return workSpacePermissionService.deleteWorkSpacePermission(id);
    }
}