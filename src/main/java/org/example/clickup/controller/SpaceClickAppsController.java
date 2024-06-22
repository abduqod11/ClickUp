package org.example.clickup.controller;

import org.example.clickup.dto.SpaceClickAppsDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceClickApps;
import org.example.clickup.service.SpaceClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SpaceCLickApps")

public class SpaceClickAppsController {
    @Autowired
    SpaceClickAppsService spaceClickAppsService;

    @GetMapping()
    public List<SpaceClickApps> getSpaceClickApps() {
        return spaceClickAppsService.getAllSPaceClicks();
    }

    @PostMapping()
    public Result addSpaceClickApps(@RequestBody SpaceClickAppsDto spaceClickAppsDto) {
        return spaceClickAppsService.CreateSpaceClickApps(spaceClickAppsDto);
    }

    @PutMapping()
    public Result updateSpaceCLickApps(@RequestBody SpaceClickAppsDto spaceClickAppsDto,@PathVariable Long id) {
        return spaceClickAppsService.UpdateClickApps(spaceClickAppsDto,id);
    }

    @DeleteMapping()
    public Result deleteSpaceClickApps(@PathVariable Long id) {
        return spaceClickAppsService.deleteClickApps(id);
    }
}