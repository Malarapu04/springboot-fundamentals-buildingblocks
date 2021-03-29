package com.bhavni.restservices.controller;

import com.bhavni.restservices.entities.User;
import com.bhavni.restservices.exception.UserExistsException;
import com.bhavni.restservices.exception.UserNotFoundException;
import com.bhavni.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/getallusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) throws UserExistsException {
        userService.createUser(user);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @GetMapping("/userById/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        try {
            return userService.getUserById(id);
        } catch(UserNotFoundException userExec){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,userExec.getMessage());
        }
    }

    @PutMapping("/user/{id}")
    public User updateUserById(@PathVariable("id") Long id,@RequestBody User user) throws UserNotFoundException {
        return userService.updateUserById(id,user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }
}
