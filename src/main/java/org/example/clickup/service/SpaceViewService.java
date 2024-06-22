package org.example.clickup.service;

import org.example.clickup.dto.SpaceViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceView;
import org.example.clickup.model.View;
import org.example.clickup.repository.SpaceViewRepository;
import org.example.clickup.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class SpaceViewService {
    @Autowired
    SpaceViewRepository spaceViewRepository;
    @Autowired
    ViewRepository viewRepository;

    public List<SpaceView> getSpaceViews() {
        return spaceViewRepository.findAll();
    }

    public Result createSpaceView(SpaceViewDto spaceViewDto){
        SpaceView spaceView = new SpaceView();
        Optional<View> optionalView = viewRepository.findById(spaceViewDto.getViewId());
        View view = optionalView.get();
        spaceView.setViewId(view);
        Optional<SpaceView> optionalSpaceView = spaceViewRepository.findById(spaceViewDto.getSpaceId());
        SpaceView spaceViewOptional = optionalSpaceView.get();
        spaceView.setSpaceId(spaceViewOptional.getSpaceId());
        spaceViewRepository.save(spaceView);
        viewRepository.save(view);
        return new Result(true,"SpaceView Created Successfully");
    }

    public Result updateSpaceView(SpaceViewDto spaceViewDto,Long id){
        Optional<SpaceView> spaceViewRepositoryById = spaceViewRepository.findById(spaceViewDto.getSpaceId());
        if(spaceViewRepositoryById.isPresent()){
            SpaceView spaceView = spaceViewRepositoryById.get();
            Optional<View> optionalView = viewRepository.findById(spaceViewDto.getViewId());
            View view = optionalView.get();
            spaceView.setViewId(view);
            Optional<SpaceView> optionalSpaceView = spaceViewRepository.findById(spaceViewDto.getSpaceId());
            SpaceView spaceViewOptional = optionalSpaceView.get();
            spaceView.setSpaceId(spaceViewOptional.getSpaceId());
            spaceViewRepository.save(spaceView);
            viewRepository.save(view);
            return new Result(true,"SpaceView Updated Successfully");
        }
        return new Result(false,"SpaceView Not Found");
    }

    public Result deleteSpaceView(Long id){
        spaceViewRepository.deleteById(id);
        return new Result(true,"SpaceView Deleted Successfully");
    }
}