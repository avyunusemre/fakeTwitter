package com.techpro.twitter.services;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.requests.PostRequest;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface PostService {

    Long savePost(PostRequest postRequest) throws UserNotFoundException;

    List<Post> getAllUserPosts(Long userId);

    Post getPostById(Long id) throws PostNotFoundException;
}
