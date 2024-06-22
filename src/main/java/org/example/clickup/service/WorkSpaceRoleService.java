package org.example.clickup.service;

import org.example.clickup.dto.WorkSpaceRoleDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpace;
import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.repository.WorkSpaceRepository;
import org.example.clickup.repository.WorkSpaceRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class WorkSpaceRoleService {
    @Autowired
    WorkSpaceRoleRepository workSpaceRoleRepository;

    @Autowired
    WorkSpaceRepository workSpaceRepository;

    public List<WorkSpaceRole> getAllRoles() {
        return workSpaceRoleRepository.findAll();
    }

    public Result createWorkSpaceRole(WorkSpaceRoleDto workSpaceRoleDto) {
        WorkSpaceRole workSpaceRole = new WorkSpaceRole();
        workSpaceRole.setExtendsRole(workSpaceRoleDto.getExtendsRole());
        workSpaceRole.setName(workSpaceRoleDto.getName());
        Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(workSpaceRoleDto.getWorkSpaceId());
        WorkSpace workSpace = optionalWorkSpace.get();
        workSpaceRole.setWorkSpaceId(workSpace);

        workSpaceRole.setExtendsRole(workSpaceRoleDto.getExtendsRole());
        workSpaceRoleRepository.save(workSpaceRole);
        return new Result(true,"WorkSpaceRole Created Successfully");
    }

    public Result updateWorkSpaceRole(WorkSpaceRoleDto workSpaceRoleDto,Long id) {
        Optional<WorkSpaceRole> workSpaceRole = workSpaceRoleRepository.findById(id);
        if (workSpaceRole.isPresent()) {
            WorkSpaceRole spaceRole = workSpaceRole.get();
            spaceRole.setExtendsRole(workSpaceRoleDto.getExtendsRole());
            spaceRole.setName(workSpaceRoleDto.getName());
            Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(workSpaceRoleDto.getWorkSpaceId());
            WorkSpace workSpace = optionalWorkSpace.get();
            spaceRole.setWorkSpaceId(workSpace);
            workSpaceRoleRepository.save(spaceRole);
            return new Result(true,"WorkSpaceRole Updated Successfully");
        }
        return new Result(false,"WorkSpaceRole Not Found");
    }
    public Result deleteWorkSpaceRole(Long id) {
        workSpaceRoleRepository.deleteById(id);
        return new Result(true, "WorkSpaceRole Deleted Successfully");
    }
}