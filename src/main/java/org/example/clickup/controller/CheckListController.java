package org.example.clickup.controller;

import org.example.clickup.dto.CheckListDto;
import org.example.clickup.model.CheckList;
import org.example.clickup.model.Result;
import org.example.clickup.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/CheckList")

public class CheckListController {
    @Autowired
    CheckListService checkListService;

    @GetMapping()
    public List<CheckList> getAllCheckList(){
        return checkListService.getAllCheckLists();
    }

    @PostMapping()
    public Result addCheckList(@RequestBody CheckListDto checkListDto){
        return checkListService.addCheckList(checkListDto);
    }

    @PutMapping("/{id}")
    public Result editCheckList(@RequestBody CheckListDto checkListDto,@PathVariable Long id){
        return checkListService.updateCheckList(checkListDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCheckList(@PathVariable Long id){
        return checkListService.deleteCheckList(id);
    }
}