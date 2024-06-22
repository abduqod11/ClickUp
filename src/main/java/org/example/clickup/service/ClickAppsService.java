package org.example.clickup.service;

import org.example.clickup.dto.ClickAppsDto;
import org.example.clickup.model.ClickApps;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.repository.ClickAppsRepository;
import org.example.clickup.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ClickAppsService {
    @Autowired
    ClickAppsRepository clickAppsRepository;
    @Autowired
    IconRepository iconRepository;

    public List<ClickApps> getClickApps() {
        return clickAppsRepository.findAll();
    }

    public Result createCLickApps(ClickAppsDto clickAppsDto) {
        ClickApps clickApps = new ClickApps();
        clickApps.setName(clickAppsDto.getName());
        Optional<Icon> optionalIcon = iconRepository.findById(clickAppsDto.getIconId());
        Icon icon = optionalIcon.get();
        clickApps.setIconId(icon);
        clickAppsRepository.save(clickApps);
        return new Result(true,"ClickApps Created Successfully");
    }

    public Result updateCLickApps(ClickAppsDto clickAppsDto,Long id) {
        Optional<ClickApps> clickAppsOptional = clickAppsRepository.findById(id);
        if(clickAppsOptional.isPresent()) {
            ClickApps clickApps = clickAppsOptional.get();
            clickApps.setName(clickAppsDto.getName());
            Optional<Icon> optionalIcon = iconRepository.findById(clickAppsDto.getIconId());
            Icon icon = optionalIcon.get();
            clickApps.setIconId(icon);
            clickAppsRepository.save(clickApps);
            return new Result(true,"ClickApps Updated Successfully");
        }
        return new Result(false,"ClickApps Not Found");
    }

    public Result deleteCLickApps(Long id) {
        clickAppsRepository.deleteById(id);
        return new Result(true,"ClickApps Deleted Successfully");
    }
}