package com.techpro.twitter.controllers;

import com.techpro.twitter.entities.Comment;
import com.techpro.twitter.requests.CommentRequest;
import com.techpro.twitter.services.Impl.CommentServiceImpl;
import com.techpro.twitter.services.exceptions.CommentNotFoundException;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    private CommentServiceImpl commentService;

    CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addComment(@RequestBody CommentRequest commentRequest) throws PostNotFoundException, UserNotFoundException {
        return new ResponseEntity<>(commentService.addComment(commentRequest), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsForPost(@PathVariable("postId") Long postId) throws PostNotFoundException {
        return new ResponseEntity<>(commentService.getCommentsForPost(postId), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getCommentsForUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(commentService.getCommentsForUser(userId), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("commentId") Long commentId) throws CommentNotFoundException {
        return new ResponseEntity<>(commentService.getCommentById(commentId), HttpStatusCode.valueOf(200));
    }

}
