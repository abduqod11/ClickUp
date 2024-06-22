package org.example.clickup.service;

import org.example.clickup.dto.TagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.model.WorkSpace;
import org.example.clickup.repository.TagRepository;
import org.example.clickup.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TagService {
    @Autowired
    TagRepository tagRepository;
    @Autowired
    WorkSpaceRepository workSpaceRepository;

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Result createTag(TagDto tagDto){
        Tag tag = new Tag();
        tag.setColor(tagDto.getColor());
        tag.setName(tagDto.getName());
        Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(tagDto.getWorkSpaceId());
        WorkSpace workSpace = optionalWorkSpace.get();
        tag.setWorkSpaceId(workSpace);
        tagRepository.save(tag);
        return new Result(true,"Tag Created Successfully");
    }

    public Result updateTag(TagDto tagDto,Long id){
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()){
            Tag tag = optionalTag.get();
            tag.setName(tagDto.getName());
            tag.setColor(tagDto.getColor());
            Optional<WorkSpace> optionalWorkSpace = workSpaceRepository.findById(tagDto.getWorkSpaceId());
            WorkSpace workSpace = optionalWorkSpace.get();
            tag.setWorkSpaceId(workSpace);
            tagRepository.save(tag);
            return new Result(true,"Tag Updated Successfully");
        }
        return new Result(false,"Tag Not Found");
    }

    public Result deleteTag(Long id){
        tagRepository.deleteById(id);
        return new Result(true,"Tag Deleted Successfully");
    }
}