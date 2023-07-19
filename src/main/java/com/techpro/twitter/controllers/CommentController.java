package com.techpro.twitter.controllers;

import com.techpro.twitter.requests.CommentRequest;
import com.techpro.twitter.services.Impl.CommentServiceImpl;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    private CommentServiceImpl commentService;

    CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addComment(@RequestBody CommentRequest commentRequest) throws PostNotFoundException {
        return new ResponseEntity<>(commentService.addComment(commentRequest), HttpStatusCode.valueOf(200));
    }

}
