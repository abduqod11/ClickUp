package org.example.clickup.controller;

import org.example.clickup.dto.TagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tag")

public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping()
    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @PostMapping()
    public Result createTag(@RequestBody TagDto tagDto){
        return tagService.createTag(tagDto);
    }

    @PutMapping("/{id}")
    public Result updateTag(@RequestBody TagDto tagDto,@PathVariable Long id){
        return tagService.updateTag(tagDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTag(@PathVariable Long id){
        return tagService.deleteTag(id);
    }
}