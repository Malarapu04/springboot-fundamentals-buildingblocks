package com.bhavni.restservices.services;

import com.bhavni.restservices.entities.User;
import com.bhavni.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
            return userRepository.findById(id);
    }

    public User updateUserById(Long id,User user){
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);

    }
}