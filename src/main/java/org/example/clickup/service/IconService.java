package org.example.clickup.service;

import org.example.clickup.dto.IconDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.repository.AttachmentRepository;
import org.example.clickup.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class IconService {
    @Autowired
    IconRepository iconRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Icon> getAllIcons(){
        return iconRepository.findAll();
    }

    public Result createIcon(IconDto iconDto){
        Icon icon = new Icon();
        icon.setIcon(iconDto.getIcon());
        icon.setColor(iconDto.getColor());
        icon.setInitialLetter(iconDto.getInitialLetter());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(iconDto.getAttachmentId());
        Attachment attachment = optionalAttachment.get();
        icon.setAttachmentId(attachment);
        iconRepository.save(icon);
        return new Result(true,"Icon Created Successfully");
    }

    public Result updateIcon(IconDto iconDto,Long id){
        Optional<Icon> optionalIcon = iconRepository.findById(id);
        if(optionalIcon.isPresent()){
            Icon icon = optionalIcon.get();
            icon.setIcon(iconDto.getIcon());
            icon.setColor(iconDto.getColor());
            icon.setInitialLetter(iconDto.getInitialLetter());
            Optional<Attachment> optionalAttachment = attachmentRepository.findById(iconDto.getAttachmentId());
            Attachment attachment = optionalAttachment.get();
            icon.setAttachmentId(attachment);
            iconRepository.save(icon);
            return new Result(true,"Icon Updated Successfully");
        }
        return new Result(false,"Icon Not Found");
    }

    public Result deleteIcon(Long id){
        iconRepository.deleteById(id);
        return new Result(true,"Icon Deleted Successfully");
    }
}