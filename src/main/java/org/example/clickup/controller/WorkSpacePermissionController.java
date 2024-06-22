package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpacePermissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpacePermission;
import org.example.clickup.service.WorkSpacePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/WorkSpacePermission")

public class WorkSpacePermissionController {
    @Autowired
    WorkSpacePermissionService workSpacePermissionService;

    public List<WorkSpacePermission> getWorkSpacePermissions() {
        return workSpacePermissionService.getAllPermissions();
    }

    public Result addWorkSpacePermission(@RequestBody WorkSpacePermissionDto workSpacePermissionDto) {
        return workSpacePermissionService.createWorkSpacePermission(workSpacePermissionDto);
    }

    public Result deleteWorkSpacePermission(@PathVariable Long id) {
        return workSpacePermissionService.deleteWorkSpacePermission(id);
    }
}