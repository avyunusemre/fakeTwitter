package com.techpro.twitter.services;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.requests.PostRequest;
import com.techpro.twitter.services.exceptions.UserNotFoundException;

import java.util.List;

public interface PostService {

    Long savePost(PostRequest postRequest) throws UserNotFoundException;

    List<Post> getAllUserPosts(Long userId);
}
