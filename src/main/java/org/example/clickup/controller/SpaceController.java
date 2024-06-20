package org.example.clickup.controller;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/space")

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

    @PutMapping("/{id}")
    public Result editSpace(@RequestBody SpaceDto spaceDto,@PathVariable Long id){
        return spaceservice.updateSpace(spaceDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpace(@PathVariable Long id){
        return spaceservice.deleteSpace(id);
    }
}