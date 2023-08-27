package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.Comment;
import com.techpro.twitter.entities.Post;
import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.CommentRepo;
import com.techpro.twitter.requests.CommentRequest;
import com.techpro.twitter.services.CommentService;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepo commentRepo;

    private PostServiceImpl postService;

    private UserServiceImpl userService;

    CommentServiceImpl(CommentRepo commentRepo, PostServiceImpl postService, UserServiceImpl userService) {
        this.commentRepo = commentRepo;
        this.postService = postService;
        this.userService = userService;
    }

    @Override
    public Long addComment(CommentRequest commentRequest) throws PostNotFoundException, UserNotFoundException {
        Post post = postService.getPostById(commentRequest.getPostId());
        User user = userService.getUserById(commentRequest.getUserId());
        if (post != null) {
            Comment comment = new Comment();
            comment.setText(commentRequest.getText());
            comment.setPost(post);
            comment.setUser(user);
            return commentRepo.save(comment).getId();
        } else {
            return null;
        }
    }

    @Override
    public List<Comment> getCommentsForPost(Long postId) throws PostNotFoundException {
        Post post = postService.getPostById(postId);
        return commentRepo.findAllByPost_id(postId);
    }
}
