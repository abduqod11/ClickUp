package org.example.clickup.service;

import org.example.clickup.dto.AttachmentDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Attachment> getAllAttachments(){
        return attachmentRepository.findAll();
    }

    public Result createAttachment(AttachmentDto attachmentDto){
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContentType(attachmentDto.getContentType());
        attachment.setOriginalName(attachmentDto.getOriginalName());
        attachmentRepository.save(attachment);
        return new Result(true,"Attachment created");
    }

    public Result updateAttachment(Long id,AttachmentDto attachmentDto){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if(optionalAttachment.isPresent()){
            Attachment attachment = new Attachment();
            attachment.setName(attachmentDto.getName());
            attachment.setSize(attachmentDto.getSize());
            attachment.setContentType(attachmentDto.getContentType());
            attachment.setOriginalName(attachmentDto.getOriginalName());
            attachmentRepository.save(attachment);
            return new Result(true,"Attachment updated");
        }
        return new Result(false,"Attachment not found");
    }

    public Result deleteAttachmentById(Long id){
        attachmentRepository.deleteById(id);
        return new Result(true,"Attachment deleted");
    }
}