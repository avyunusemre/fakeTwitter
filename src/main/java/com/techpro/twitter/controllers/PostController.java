package com.techpro.twitter.controllers;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.requests.PostRequest;
import com.techpro.twitter.services.Impl.PostServiceImpl;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity<Long> sendPost(@RequestBody PostRequest postRequest) throws UserNotFoundException {
        return new ResponseEntity<>(postService.savePost(postRequest), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(postService.getAllUserPosts(userId));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable("postId") Long postId) throws PostNotFoundException {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

}
