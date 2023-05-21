package com.techpro.twitter.services.exceptions;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
