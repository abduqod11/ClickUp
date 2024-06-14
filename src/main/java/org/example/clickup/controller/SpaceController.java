package org.example.clickup.controller;

import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service

public class SpaceController {
    @Autowired
    SpaceService spaceservice;

    @GetMapping()
    public List<Space> getAllSpaces(){
        return spaceservice.getAllSpaces();
    }

    @PostMapping()
    public Result addSpace(@RequestBody SpaceDto spaceDto){
        return spaceservice.createSpace(spaceDto);
    }

    @PostMapping("/{id}")
    public Result editSpace(@RequestBody SpaceDto spaceDto,@PathVariable Long id){
        return spaceservice.updateSpace(spaceDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpace(@PathVariable Long id){
        return spaceservice.deleteSpace(id);
    }
}