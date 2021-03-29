package com.bhavni.restservices.services;

import com.bhavni.restservices.entities.User;
import com.bhavni.restservices.exception.UserExistsException;
import com.bhavni.restservices.exception.UserNotFoundException;
import com.bhavni.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user) throws UserExistsException {
        User users=userRepository.findByUsername(user.getUsername());
        if(users!=null){
            throw new UserExistsException("User already available");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
       Optional<User> user=userRepository.findById(id);
       if(!user.isPresent()){
          throw new UserNotFoundException("User not found");
       }
            return user;
    }

    public User updateUserById(Long id,User user) throws UserNotFoundException{
        Optional<User> users=userRepository.findById(id);
        if(!users.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No user exists");
        }
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
