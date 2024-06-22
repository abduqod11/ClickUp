package org.example.clickup.service;

import org.example.clickup.dto.PriorityDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Priority;
import org.example.clickup.model.Result;
import org.example.clickup.repository.IconRepository;
import org.example.clickup.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class PriorityService {
    @Autowired
    PriorityRepository priorityRepository;
    @Autowired
    IconRepository iconRepository;

    public List<Priority> getAllPriority(){
        return priorityRepository.findAll();
    }

    public Result createPriority(PriorityDto priorityDto){
        Priority priority = new Priority();
        priority.setName(priority.getName());
        Optional<Icon> optionalIcon = iconRepository.findById(priorityDto.getIconId());
        Icon icon = optionalIcon.get();
        priority.setIconId(icon);
        priorityRepository.save(priority);
        return new Result(true,"Priority Created Successfully");
    }

    public Result updatePriority(PriorityDto priorityDto,Long id){
        Optional<Priority> optionalPriority = priorityRepository.findById(id);
        if (optionalPriority.isPresent()) {
            Priority priority = optionalPriority.get();
            priority.setName(priorityDto.getName());
            Optional<Icon> optionalIcon = iconRepository.findById(priorityDto.getIconId());
            Icon icon = optionalIcon.get();
            priority.setIconId(icon);
            priorityRepository.save(priority);
            return new Result(true,"Priority Updated Successfully");
        }
        return new Result(false,"Priority Not Found");
    }

    public Result deletePriority(Long id){
        priorityRepository.deleteById(id);
        return new Result(true,"Priority Deleted Successfully");
    }
}