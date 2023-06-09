package com.techpro.twitter.services;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();

    User getUserById(Long id) throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;

    Long addNewuser(User saveToUser) throws UserAlreadyExistException;
}
