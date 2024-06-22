package org.example.clickup.controller;

import org.example.clickup.dto.CheckListDto;
import org.example.clickup.dto.CheckListItemDto;
import org.example.clickup.model.CheckListItem;
import org.example.clickup.model.Result;
import org.example.clickup.service.CheckListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/CheckListItem")

public class CheckListItemController {
    @Autowired
    CheckListItemService checkListItemService;

    public List<CheckListItem> getAllCheckListItem(){
        return checkListItemService.getAllCheckListItems();
    }

    public Result createCheckListItem(@RequestBody CheckListItemDto checkListItemDto){
        return checkListItemService.addCheckListItem(checkListItemDto);
    }

    public Result editCheckListItem(@RequestBody CheckListItemDto checkListItemDto, @PathVariable Long id){
        return checkListItemService.updateCheckListItem(checkListItemDto,id);
    }

    public Result deleteCheckListItem(@PathVariable Long id){
        return checkListItemService.deleteCheckListItem(id);
    }
}