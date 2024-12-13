package org.example.clickup.controller;

import org.example.clickup.dto.SpaceViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceView;
import org.example.clickup.service.SpaceViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/SpaceView")

public class SpaceViewController {
    @Autowired
    SpaceViewService spaceViewService;

    @GetMapping()
    public List<SpaceView> getAllSpaceViews() {
        return spaceViewService.getSpaceViews();
    }

    @PostMapping()
    public Result addSpaceView(@RequestBody SpaceViewDto spaceViewDto) {
        return spaceViewService.createSpaceView(spaceViewDto);
    }

    @PostMapping("/{id}")
    public Result updateSpaceView(@RequestBody SpaceViewDto spaceViewDto,@PathVariable Long id) {
        return spaceViewService.updateSpaceView(spaceViewDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpaceView(@PathVariable Long id) {
        return spaceViewService.deleteSpaceView(id);
    }
}