package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.Comment;
import com.techpro.twitter.entities.Post;
import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.CommentRepo;
import com.techpro.twitter.requests.CommentRequest;
import com.techpro.twitter.services.CommentService;
import com.techpro.twitter.services.exceptions.CommentNotFoundException;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Nullable
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

    @Nullable
    @Override
    public List<Comment> getCommentsForPost(Long postId) throws PostNotFoundException {
        Post post = postService.getPostById(postId);
        if (post != null) {
            return commentRepo.findAllByPost_id(postId);
        }
        return null;
    }

    @Nullable
    @Override
    public List<Comment> getCommentsForUser(Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        if (user != null) {
            return commentRepo.findAllByUser_id(userId);
        }
        return null;
    }

    @Override
    public Comment getCommentById(Long commentId) throws CommentNotFoundException {
        Optional<Comment> commentOptional = commentRepo.findById(commentId);
        if (commentOptional.isPresent()) {
            return commentOptional.get();
        } else {
            throw new CommentNotFoundException("Comment with id: " + commentId + " couldn't find.");
        }
    }
}
