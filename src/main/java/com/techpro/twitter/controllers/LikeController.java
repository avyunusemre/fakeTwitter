package com.techpro.twitter.controllers;

import com.techpro.twitter.entities.Like;
import com.techpro.twitter.services.Impl.LikeServiceImpl;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/like")
public class LikeController {

    private final LikeServiceImpl likeService;

    public LikeController(LikeServiceImpl likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getLikesForPost(@PathVariable("postId") Long postId) throws PostNotFoundException {
        return new ResponseEntity<>(likeService.getAllLikesForPost(postId), HttpStatusCode.valueOf(200));
    }


    @PostMapping("/add/{postId}")
    public ResponseEntity<Long> addLikeForPost(@PathVariable("postId") Long postId, @RequestParam(name = "userId") Long userId)
            throws PostNotFoundException, UserNotFoundException {
        return new ResponseEntity<>(likeService.addLikeForPost(postId, userId), HttpStatusCode.valueOf(200));
    }
}
