package org.example.clickup.service;

import org.example.clickup.dto.WorkSpaceUserDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.UserRepository;
import org.example.clickup.repository.WorkSpaceRepository;
import org.example.clickup.repository.WorkSpaceRoleRepository;
import org.example.clickup.repository.WorkSpaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class WorkSpaceUserService {
    @Autowired
    WorkSpaceUserRepository workSpaceUserRepository;
    @Autowired
    WorkSpaceRepository workSpaceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WorkSpaceRoleRepository workSpaceRoleRepository;

    public List<WorkSpaceUser> getAllWorkSpaceUsers() {
        return workSpaceUserRepository.findAll();
    }

    public Result createWorkSpaceUser(WorkSpaceUserDto workSpaceUserDto){
        WorkSpaceUser workSpaceUser = new WorkSpaceUser();

        Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(workSpaceUserDto.getWorkSpaceId());
        WorkSpace workSpace = optionalWorkSpace.get();
        workSpaceUser.setWorkSpaceId((List<WorkSpace>) workSpace);

        Optional<User> optionalUser = userRepository.findById(workSpaceUserDto.getUserId());
        User user = optionalUser.get();
        workSpaceUser.setUserId((List<User>) user);

        Optional<WorkSpaceRole> workSpaceRole = workSpaceRoleRepository.findById(workSpaceUserDto.getWorkSpaceRole());
        WorkSpaceRole spaceRole = workSpaceRole.get();
        workSpaceUser.setWorkSpaceRoleId((List<WorkSpaceRole>) spaceRole);

        workSpaceUserRepository.save(workSpaceUser);
        return new Result(true,"WorkSpaceUser Created Successfully");
    }

    public Result updateWorkSpaceUser(WorkSpaceUserDto workSpaceUserDto,Long id){
        Optional<WorkSpaceUser> optionalWorkSpaceUser = workSpaceUserRepository.findById(id);
        if(optionalWorkSpaceUser.isPresent()){
            WorkSpaceUser workSpaceUser = optionalWorkSpaceUser.get();
            Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(workSpaceUserDto.getWorkSpaceId());
            WorkSpace workSpace = optionalWorkSpace.get();
            workSpaceUser.setWorkSpaceId((List<WorkSpace>) workSpace);

            Optional<User> optionalUser = userRepository.findById(workSpaceUserDto.getUserId());
            User user = optionalUser.get();
            workSpaceUser.setUserId((List<User>) user);

            Optional<WorkSpaceRole> workSpaceRole = workSpaceRoleRepository.findById(workSpaceUserDto.getWorkSpaceRole());
            WorkSpaceRole spaceRole = workSpaceRole.get();
            workSpaceUser.setWorkSpaceRoleId((List<WorkSpaceRole>) spaceRole);
            workSpaceUserRepository.save(workSpaceUser);
            return new Result(true,"WorkSpaceUser Updated Successfully");
        }
        return new Result(false,"WorkSpaceUser updated Successfully");
    }

    public Result deleteWorkSpaceUser(Long id){
        workSpaceUserRepository.deleteById(id);
        return new Result(true,"WorkSpaceUser Deleted Successfully");
    }
}