package org.example.clickup.controller;

import org.example.clickup.dto.ClickAppsDto;
import org.example.clickup.model.ClickApps;
import org.example.clickup.model.Result;
import org.example.clickup.service.ClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClickApps")

public class ClickAppsController {
    @Autowired
    ClickAppsService clickAppsService;

    @GetMapping()
    public List<ClickApps> findAll(){
        return clickAppsService.getClickApps();
    }

    @PostMapping()
    public Result addClickApp(@RequestBody ClickAppsDto clickAppsDto){
        return clickAppsService.createCLickApps(clickAppsDto);
    }

    @PutMapping()
    public Result updateClickApp(@RequestBody ClickAppsDto clickAppsDto,@PathVariable Long id){
        return clickAppsService.updateCLickApps(clickAppsDto,id);
    }

    @DeleteMapping()
    public Result deleteClickApp(@PathVariable Long id){
        return clickAppsService.deleteCLickApps(id);
    }
}