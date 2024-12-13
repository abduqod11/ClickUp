package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpaceRoleDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.service.WorkSpaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/WorkSpaceRole")

public class WorkSpaceRoleController {
    @Autowired
    WorkSpaceRoleService workSpaceRoleService;

    @GetMapping()
    public List<WorkSpaceRole> getAll() {
        return workSpaceRoleService.getAllRoles();
    }

    @PostMapping()
    public Result add(@RequestBody WorkSpaceRoleDto workSpaceRoleDto) {
        return workSpaceRoleService.createWorkSpaceRole(workSpaceRoleDto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody WorkSpaceRoleDto workSpaceRoleDto,@PathVariable Long id) {
        return workSpaceRoleService.updateWorkSpaceRole(workSpaceRoleDto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return workSpaceRoleService.deleteWorkSpaceRole(id);
    }
}