package com.techpro.twitter.services.exceptions;

public class CommentNotFoundException extends Throwable {
    public CommentNotFoundException(String message) {
        super(message);
    }
}
