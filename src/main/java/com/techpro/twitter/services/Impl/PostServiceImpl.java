package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.PostRepo;
import com.techpro.twitter.repositories.UserRepo;
import com.techpro.twitter.requests.PostRequest;
import com.techpro.twitter.services.PostService;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepo postRepo;

    private UserRepo userRepo;

    public PostServiceImpl(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Long savePost(PostRequest postRequest) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(postRequest.getUserId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User could not found with id: " + postRequest.getUserId());
        } else {
            Post postToSave = new Post();
            postToSave.setTitle(postRequest.getTitle());
            postToSave.setText(postRequest.getText());
            postToSave.setUser(optionalUser.get());
            return postRepo.save(postToSave).getId();
        }
    }

    @Override
    public List<Post> getAllUserPosts(Long userId) {
        return postRepo.findAllByUser_id(userId);
    }

    @Override
    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postOptional = postRepo.findById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new PostNotFoundException("Post could not found with id: " + id);
        }
    }
}
