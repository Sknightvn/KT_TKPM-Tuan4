package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUser() { return userService.findAllUser();}

    @PutMapping
    public User modifyUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{Id}")
    public String deleteUser(@PathVariable String Id){
        return userService.deleteUser(Id);
    }
}
