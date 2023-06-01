package com.moviedatabase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviedatabase.entities.User;
import com.moviedatabase.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void createUsers(List<User> users){
        userRepository.saveAll(users);
    }

    public void updatePassword(long id,String name){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setPassword(name);
            userRepository.save(user);
        }
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
    
}
