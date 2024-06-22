package org.example.clickup.service;

import org.example.clickup.dto.ViewDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.model.View;
import org.example.clickup.repository.IconRepository;
import org.example.clickup.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ViewService {
    @Autowired
    ViewRepository viewRepository;
    @Autowired
    IconRepository iconRepository;

    public List<View> getAllViews() {
        return viewRepository.findAll();
    }

    public Result createView(ViewDto viewDto) {
        View view = new View();
        view.setName(viewDto.getName());
        Optional<Icon> optionalIcon = iconRepository.findById(viewDto.getIconId());
        Icon icon = optionalIcon.get();
        view.setIconId(icon);
        viewRepository.save(view);
        return new Result(true,"View Created Successfully");
    }

    public Result updateView(ViewDto viewDto,Long id) {
        Optional<View> optionalView = viewRepository.findById(id);
        if (optionalView.isPresent()) {
            View view = optionalView.get();
            view.setName(viewDto.getName());
            Optional<Icon> optionalIcon = iconRepository.findById(viewDto.getIconId());
            Icon icon = optionalIcon.get();
            view.setIconId(icon);
            viewRepository.save(view);
            return new Result(true,"View Updated Successfully");
        }
        return new Result(false,"View Not Found");
    }

    public Result deleteView(Long id) {
        viewRepository.deleteById(id);
        return new Result(true,"View Deleted Successfully");
    }
}