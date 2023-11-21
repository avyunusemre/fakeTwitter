package com.techpro.twitter.services;

import com.techpro.twitter.entities.Like;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface LikeService {

    List<Like> getAllLikesForPost(Long postId) throws PostNotFoundException;

    Long addLikeForPost(Long postId, Long userId) throws PostNotFoundException, UserNotFoundException;
}
