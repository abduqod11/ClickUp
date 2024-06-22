package org.example.clickup.service;

import org.example.clickup.dto.CheckListDto;
import org.example.clickup.model.CheckList;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.repository.CheckListRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CheckListService {
    @Autowired
    CheckListRepository checkListRepository;
    @Autowired
    TaskRepository taskRepository;

    public List<CheckList> getAllCheckLists() {
        return checkListRepository.findAll();
    }

    public Result addCheckList(CheckListDto checkListDto) {
        CheckList checkList = new CheckList();
        checkList.setName(checkListDto.getName());
        Optional<Task> optionalTask = taskRepository.findById(checkListDto.getTaskId());
        Task task = optionalTask.get();
        checkList.setTaskId(task);
        checkListRepository.save(checkList);
        return new Result(true,"CheckList Created Successfully");
    }

    public Result updateCheckList(CheckListDto checkListDto,Long id) {
        Optional<CheckList> optionalCheckList = checkListRepository.findById(id);
        if (optionalCheckList.isPresent()){
            CheckList checkList = optionalCheckList.get();
            checkList.setName(checkListDto.getName());
            Optional<Task> optionalTask = taskRepository.findById(checkListDto.getTaskId());
            Task task = optionalTask.get();
            checkList.setTaskId(task);
            checkListRepository.save(checkList);
            return new Result(true,"CheckList Updated Successfully");
        }
        return new Result(false,"CheckList Not Found");
    }

    public Result deleteCheckList(Long id) {
        checkListRepository.deleteById(id);
        return new Result(true,"CheckList Deleted Successfully");
    }
}