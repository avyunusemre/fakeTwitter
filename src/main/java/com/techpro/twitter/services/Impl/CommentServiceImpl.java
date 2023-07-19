package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.Comment;
import com.techpro.twitter.entities.Post;
import com.techpro.twitter.repositories.CommentRepo;
import com.techpro.twitter.requests.CommentRequest;
import com.techpro.twitter.requests.PostRequest;
import com.techpro.twitter.services.CommentService;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepo commentRepo;

    private PostServiceImpl postService;

    CommentServiceImpl(CommentRepo commentRepo, PostServiceImpl postService) {
        this.commentRepo = commentRepo;
        this.postService = postService;
    }

    @Override
    public Long addComment(CommentRequest commentRequest) throws PostNotFoundException {
        Post post = postService.getPostById(commentRequest.getPost_id());
        if (post != null) {
            Comment comment = new Comment();
            comment.setText(commentRequest.getText());
            comment.setPost(post);
            return commentRepo.save(comment).getId();
        } else {
            return null;
        }
    }
}
