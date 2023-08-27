package com.techpro.twitter.services;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserService {
    List<User> getAllUser();

    User getUserById(Long id) throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;

    Long addNewUser(User saveToUser) throws UserAlreadyExistException;
}
