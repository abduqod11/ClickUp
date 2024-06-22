package org.example.clickup.service;

import org.example.clickup.dto.SpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.SpaceUser;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.SpaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class SpaceUserService {
    @Autowired
    SpaceUserRepository spaceUserRepository;
    @Autowired
    SpaceRepository spaceRepository;

    public List<SpaceUser> getAllSpaceUsers() {
        return spaceUserRepository.findAll();
    }

    public Result createSpaceUser(SpaceUserDto spaceUserDto) {
        SpaceUser spaceUser = new SpaceUser();
        Optional<Space> optionalSpace = spaceRepository.findById(spaceUserDto.getSpaceId());
        Space space = optionalSpace.get();
        spaceUser.setSpaceId(space);
        spaceUserRepository.save(spaceUser);
        return new Result(true,"SpaceUser Created Successfully");
    }

    public Result updateSpaceUser(SpaceUserDto spaceUserDto, Long Id) {
        Optional<SpaceUser> optionalSpace_user = spaceUserRepository.findById(Id);
        if (optionalSpace_user.isPresent()) {
            SpaceUser space_user = optionalSpace_user.get();
            Optional<Space> optionalSpace = spaceRepository.findById(spaceUserDto.getSpaceId());
            Space space = optionalSpace.get();
            space_user.setSpaceId(space);
            space_user.setMemberId(spaceUserDto.getMemberId());
            spaceUserRepository.save(space_user);
            return new Result(true,"SpaceUser Updated Successfully");
        }
        return new Result(false,"SpaceUser Not Found");
    }

    public Result deleteSpaceUser(Long id) {
        spaceUserRepository.deleteById(id);
        return new Result(true,"SpaceUser Deleted Successfully");
    }
}