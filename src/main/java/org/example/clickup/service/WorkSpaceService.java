package org.example.clickup.service;

import org.example.clickup.dto.WorkSpaceDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.model.WorkSpace;
import org.example.clickup.repository.AttachmentRepository;
import org.example.clickup.repository.UserRepository;
import org.example.clickup.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class WorkSpaceService {
    @Autowired
    WorkSpaceRepository workSpaceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<WorkSpace> getAllWorkSpaces() {
        return workSpaceRepository.findAll();
    }

    public WorkSpace getWorkSpaceById(Long id) {
        return workSpaceRepository.findById(id).get();
    }

    public Result createWorkSpace(WorkSpaceDto workSpaceDto) {
        boolean existsByName = workSpaceRepository.existsByName(workSpaceDto.getName());
        if(existsByName) {
            return new Result(true,"WorkSpace already exists");
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setName(workSpaceDto.getName());
        workSpace.setColor(workSpaceDto.getColor());
        workSpace.setInitialLetter(workSpaceDto.getInitialLetter());
        Optional<User> optionalUser = userRepository.findById(workSpaceDto.getUserId());
        User user = optionalUser.get();
        workSpace.setUser(user);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(workSpaceDto.getAvatarId());
        Attachment attachment = optionalAttachment.get();
        workSpace.setAvatarId(attachment);
        workSpaceRepository.save(workSpace);
        return new Result(true,"WorkSpace Created");
    }

    public Result updateWorkSpace(WorkSpaceDto workSpaceDto,Long id) {
        Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(id);
        if(optionalWorkSpace.isPresent()){
            WorkSpace workSpace = new WorkSpace();
            workSpace.setName(workSpaceDto.getName());
            workSpace.setColor(workSpaceDto.getColor());
            workSpace.setInitialLetter(workSpaceDto.getInitialLetter());
            workSpaceRepository.save(workSpace);
            return new Result(true,"WorkSpace updated");
        }
        return new Result(false,"WorkSPace not found");
    }

    public Result deleteWorkSpaceById(Long id ){
        workSpaceRepository.deleteById(id);
        return new Result(true,"WorkSpace deleted");
    }
}
