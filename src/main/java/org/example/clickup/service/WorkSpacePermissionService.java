package org.example.clickup.service;

import org.example.clickup.dto.WorkSpacePermissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpacePermission;
import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.repository.WorkSpacePermissionRepository;
import org.example.clickup.repository.WorkSpaceRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class WorkSpacePermissionService {
    @Autowired
    WorkSpacePermissionRepository workSpacePermissionRepository;

    @Autowired
    WorkSpaceRoleRepository workSpaceRoleRepository;

    public List<WorkSpacePermission> getAllPermissions() {
        return workSpacePermissionRepository.findAll();
    }

    public Result createWorkSpacePermission(WorkSpacePermissionDto workSpacePermissionDto) {
        WorkSpacePermission workSpacePermission = new WorkSpacePermission();
        Optional<WorkSpaceRole> workSpaceRole = workSpaceRoleRepository.findById(workSpacePermissionDto.getWorkSpaceRoleId());
        WorkSpaceRole spaceRole = workSpaceRole.get();
        workSpacePermission.setWorkSpaceRoleId(spaceRole);
        workSpacePermissionRepository.save(workSpacePermission);
        return new Result(true,"WorkSpacePermission created Successfully");
    }

    public Result deleteWorkSpacePermission(Long id) {
        workSpacePermissionRepository.deleteById(id);
        return new Result(true,"WorkSpacePermission deleted Successfully");
    }
}