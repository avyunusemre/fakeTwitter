package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.Like;
import com.techpro.twitter.entities.Post;
import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.LikeRepo;
import com.techpro.twitter.services.LikeService;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepo likeRepo;
    private final PostServiceImpl postService;

    private final UserServiceImpl userService;

    public LikeServiceImpl(LikeRepo likeRepo, PostServiceImpl postService, UserServiceImpl userService) {
        this.likeRepo = likeRepo;
        this.postService = postService;
        this.userService = userService;
    }

    @Nullable
    @Override
    public List<Like> getAllLikesForPost(Long postId) throws PostNotFoundException {
       Post post = postService.getPostById(postId);
       if (post != null) {
           return likeRepo.findAllByPost_id(postId);
       }
       return null;
    }

    @Override
    public Long addLikeForPost(Long postId, Long userId) throws PostNotFoundException, UserNotFoundException {
        Post post = postService.getPostById(postId);
        User user = userService.getUserById(userId);
        if (post != null && user != null) {
            Like like = new Like();
            like.setPost(post);
            like.setUser(user);
            return likeRepo.save(like).getId();
        }
        return null;
    }
}
