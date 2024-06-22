package org.example.clickup.controller;

import org.example.clickup.dto.ViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.View;
import org.example.clickup.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/View")

public class ViewController {
    @Autowired
    ViewService viewService;

    @GetMapping()
    public List<View> getViews() {
        return viewService.getAllViews();
    }

    @PostMapping()
    public Result createView(@RequestBody ViewDto viewDto) {
        return viewService.createView(viewDto);
    }

    @PutMapping()
    public Result updateView(@RequestBody ViewDto viewDto,@PathVariable Long id) {
        return viewService.updateView(viewDto, id);
    }

    @DeleteMapping()
    public Result deleteView(@PathVariable Long id) {
        return viewService.deleteView(id);
    }
}