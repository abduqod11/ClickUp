package org.example.clickup.service;

import org.example.clickup.dto.SpaceClickAppsDto;
import org.example.clickup.model.ClickApps;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.model.SpaceClickApps;
import org.example.clickup.repository.ClickAppsRepository;
import org.example.clickup.repository.SpaceClickAppsRepository;
import org.example.clickup.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class SpaceClickAppsService {
    @Autowired
    SpaceClickAppsRepository spaceClickAppsRepository;
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    ClickAppsRepository clickAppsRepository;

    public List<SpaceClickApps> getAllSPaceClicks(){
        return spaceClickAppsRepository.findAll();
    }

    public Result CreateSpaceClickApps(SpaceClickAppsDto spaceClickAppsDto){
        SpaceClickApps spaceClickApps = new SpaceClickApps();
        Optional<Space> optionalSpace = spaceRepository.findById(spaceClickAppsDto.getSpaceId());
        Space space = optionalSpace.get();
        spaceClickApps.setSpaceId(space);
        Optional<ClickApps> appsOptional = clickAppsRepository.findById(spaceClickAppsDto.getClickAppsId());
        ClickApps clickApps = appsOptional.get();
        spaceClickApps.setClickAppsId(clickApps);
        spaceClickAppsRepository.save(spaceClickApps);
        return new Result(true,"SpaceCLickApps created Successfully");
    }

    public Result UpdateClickApps(SpaceClickAppsDto spaceClickAppsDto,Long id){
        Optional<SpaceClickApps> clickAppsRepositoryById = spaceClickAppsRepository.findById(id);
        if(clickAppsRepositoryById.isPresent()){
            SpaceClickApps spaceClickApps = clickAppsRepositoryById.get();
            Optional<Space> optionalSpace = spaceRepository.findById(spaceClickAppsDto.getSpaceId());
            Space space = optionalSpace.get();
            spaceClickApps.setSpaceId(space);
            Optional<ClickApps> appsOptional = clickAppsRepository.findById(spaceClickAppsDto.getClickAppsId());
            ClickApps clickApps = appsOptional.get();
            spaceClickApps.setClickAppsId(clickApps);
            spaceClickAppsRepository.save(spaceClickApps);
            return new Result(true,"SpaceCLickApps Updated Successfully");
        }
        return new Result(false,"SpaceCLickApps Not Found");
    }

    public Result deleteClickApps(Long id){
        clickAppsRepository.deleteById(id);
        return new Result(true,"SpaceCLickApps Deleted Successfully");
    }
}