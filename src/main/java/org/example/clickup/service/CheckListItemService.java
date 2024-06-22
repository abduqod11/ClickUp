package org.example.clickup.service;

import org.example.clickup.dto.CheckListItemDto;
import org.example.clickup.model.CheckListItem;
import org.example.clickup.model.Result;
import org.example.clickup.repository.CheckListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CheckListItemService {
    @Autowired
    CheckListItemRepository checkListItemRepository;

    public List<CheckListItem> getAllCheckListItems() {
        return checkListItemRepository.findAll();
    }

    public Result addCheckListItem(CheckListItemDto checkListItemDto) {
        CheckListItem checkListItem = new CheckListItem();
        checkListItem.setName(checkListItemDto.getName());
        checkListItem.setResolved(checkListItem.getResolved());
        checkListItem.setChecklistId(checkListItem.getChecklistId());
        checkListItem.setAssignedUserId(checkListItem.getAssignedUserId());
        checkListItemRepository.save(checkListItem);
        return new Result(true,"CheckListItem created successfully");
    }

    public Result updateCheckListItem(CheckListItemDto checkListItemDto,Long id) {
        Optional<CheckListItem> optionalCheckListItem = checkListItemRepository.findById(id);
        if(optionalCheckListItem.isPresent()) {
            CheckListItem checkListItem = optionalCheckListItem.get();
            checkListItem.setName(checkListItemDto.getName());
            checkListItem.setResolved(checkListItemDto.getResolved());
            checkListItem.setChecklistId(checkListItemDto.getChecklistId());
            checkListItem.setAssignedUserId(checkListItemDto.getAssignedUserId());
            checkListItemRepository.save(checkListItem);
            return new Result(true,"CheckListItem created successfully");
        }
        return new Result(false,"CheckListItem not found");
    }

    public Result deleteCheckListItem(Long id) {
        checkListItemRepository.deleteById(id);
        return new Result(true,"CheckListItem removed successfully");
    }
}