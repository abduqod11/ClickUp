package org.example.clickup.controller;

import org.example.clickup.dto.SpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceUser;
import org.example.clickup.service.SpaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/SpaceUser")

public class SpaceUserController {
    @Autowired
    SpaceUserService spaceUserService;

    @GetMapping()
    public List<SpaceUser> getSpaceUsers() {
        return spaceUserService.getAllSpaceUsers();
    }

    @PostMapping()
    public Result createSpaceUser(@RequestBody SpaceUserDto spaceUserDto){
        return spaceUserService.createSpaceUser(spaceUserDto);
    }
    @PutMapping("/{id}")
    public Result updateSpaceUser(@RequestBody SpaceUserDto spaceUserDto, @PathVariable Long id){
        return spaceUserService.updateSpaceUser(spaceUserDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpaceUser(@PathVariable Long id){
        return spaceUserService.deleteSpaceUser(id);
    }
}