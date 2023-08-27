package com.techpro.twitter.controllers;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.services.Impl.UserServiceImpl;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User userToSave) throws UserAlreadyExistException {
        userService.addNewUser(userToSave);
        return ResponseEntity.ok(userToSave);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
    }

}
