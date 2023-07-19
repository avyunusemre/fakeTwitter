package com.techpro.twitter.services.exceptions;

public class PostNotFoundException extends Throwable{

    public PostNotFoundException(String message) {
        super(message);
    }
}
