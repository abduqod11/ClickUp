package org.example.clickup.service;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.WorkSpace;
import org.example.clickup.repository.IconRepository;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class SpaceService {
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    WorkSpaceRepository workSpaceRepository;
    @Autowired
    IconRepository iconRepository;

    public List<Space> getAllSpaces(){
        return spaceRepository.findAll();
    }

    public Result createSpace(SpaceDto spaceDto){
        boolean exists = spaceRepository.existsByName(spaceDto.getName());
        if(exists){
            return new Result(false,"Space already exists");
        }
        Space space = new Space();
        space.setName(spaceDto.getName());
        space.setColor(spaceDto.getColor());
        space.setInitialLetter(spaceDto.getInitialLetter());
        space.setAvatarId(spaceDto.getAvatarId());
        space.setAccessType(spaceDto.getAccessType());
        space.setOwnerId(spaceDto.getOwnerId());
        Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(spaceDto.getWorkSpaceId());
        WorkSpace workSpace = optionalWorkSpace.get();
        space.setWorkSpaceId(workSpace);
        Optional<Icon> optionalIcon = iconRepository.findById(spaceDto.getIconId());
        Icon icon = optionalIcon.get();
        space.setIcon(icon);
        spaceRepository.save(space);
        return new Result(true,"Space Created Successfully");
    }

    public Result updateSpace(SpaceDto spaceDto,Long id){
        Optional<Space> optionalSpace = spaceRepository.findById(id);
        if(optionalSpace.isPresent()){
            Space space = optionalSpace.get();
            space.setName(spaceDto.getName());
            space.setColor(spaceDto.getColor());
            space.setInitialLetter(spaceDto.getInitialLetter());
            space.setAvatarId(spaceDto.getAvatarId());
            space.setAccessType(spaceDto.getAccessType());
            space.setOwnerId(spaceDto.getOwnerId());
            Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(spaceDto.getWorkSpaceId());
            WorkSpace workSpace = optionalWorkSpace.get();
            space.setWorkSpaceId(workSpace);
            Optional<Icon> optionalIcon = iconRepository.findById(spaceDto.getIconId());
            Icon icon = optionalIcon.get();
            space.setIcon(icon);
            spaceRepository.save(space);
            return new Result(true,"Space Updated Successfully");
        }
        return new Result(false,"Space Not Found");
    }

    public Result deleteSpace(Long id){
        spaceRepository.deleteById(id);
        return new Result(true,"Space Deleted Successfully");
    }
}