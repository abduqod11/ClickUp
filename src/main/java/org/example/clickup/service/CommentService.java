package org.example.clickup.service;

import org.example.clickup.dto.CommentDto;
import org.example.clickup.model.Comment;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.repository.CommentRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TaskRepository taskRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Result createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        Optional<Task> optionalTask = taskRepository.findById(commentDto.getTaskId());
        Task task = optionalTask.get();
        comment.setTaskId(task);
        commentRepository.save(comment);
        return new Result(true,"Comment Created Successfully");
    }

    public Result updateComment(CommentDto commentDto,Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if(commentOptional.isPresent()){
            Comment comment = commentOptional.get();
            comment.setName(commentDto.getName());
            Optional<Task> optionalTask = taskRepository.findById(commentDto.getTaskId());
            Task task = optionalTask.get();
            comment.setTaskId(task);
            commentRepository.save(comment);
            return new Result(true,"Comment Updated Successfully");
        }
        return new Result(false,"Comment Not Found");
    }

    public Result deleteComment(Long id) {
        commentRepository.deleteById(id);
        return new Result(true,"Comment Deleted Successfully");
    }
}