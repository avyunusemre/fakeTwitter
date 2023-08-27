package com.techpro.twitter.services;

import com.techpro.twitter.entities.Comment;
import com.techpro.twitter.requests.CommentRequest;
import com.techpro.twitter.services.exceptions.PostNotFoundException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CommentService {

    Long addComment(CommentRequest commentRequest) throws PostNotFoundException, UserNotFoundException;

    List<Comment> getCommentsForPost(Long postId) throws PostNotFoundException;
}
