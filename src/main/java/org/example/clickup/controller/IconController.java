package org.example.clickup.controller;

import org.example.clickup.dto.IconDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")

public class IconController {
    @Autowired
    IconService iconService;

    @GetMapping()
    public List<Icon> getAllIcons(){
       return iconService.getAllIcons();
    }

    @PostMapping()
    public Result addIcon(@RequestBody IconDto iconDto){
        return iconService.createIcon(iconDto);
    }

    @PutMapping("/{id")
    public Result editIcon(@RequestBody IconDto iconDto,@PathVariable Long id){
        return iconService.updateIcon(iconDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteIconById(@PathVariable Long id){
        return iconService.deleteIcon(id);
    }
}