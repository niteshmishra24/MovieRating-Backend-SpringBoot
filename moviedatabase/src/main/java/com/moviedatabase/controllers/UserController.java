package com.moviedatabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviedatabase.entities.User;
import com.moviedatabase.services.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping("users")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PostMapping("users/multiple")
    public void createUsers(@RequestBody List<User> users){
        userService.createUsers(users);
    }

    @PutMapping("users/{id}")
    public void updatePassword(@PathVariable long id,@RequestParam String name){
        userService.updatePassword(id, name);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}
