package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.UserRepo;
import com.techpro.twitter.services.UserService;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User couldn't found with id: " + id);
        }
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User couldn't found with email: " + email);
        }
    }

    @Override
    public Long addNewuser(User saveToUser) throws UserAlreadyExistException {
        if (userRepo.findByEmail(saveToUser.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("User with email:" + saveToUser.getEmail() + " is already exist");
        }
        return userRepo.save(saveToUser).getId();
    }
}
