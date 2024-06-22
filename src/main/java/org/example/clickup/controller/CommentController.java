package org.example.clickup.controller;

import org.example.clickup.dto.CommentDto;
import org.example.clickup.model.Comment;
import org.example.clickup.model.Result;
import org.example.clickup.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Comment")

public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping()
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @PostMapping()
    public Result addComment(@RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @PutMapping()
    public Result updateComment(@RequestBody CommentDto commentDto,@PathVariable Long id) {
        return commentService.updateComment(commentDto,id);
    }

    @DeleteMapping()
    public Result deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}