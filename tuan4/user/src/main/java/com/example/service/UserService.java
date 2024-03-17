package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString().split("-")[0]);
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(User userRequest) {
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        User existingUser = userRepository.findById(userRequest.getId()).get();
        existingUser.setName(userRequest.getName());
        return userRepository.save(existingUser);
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return userId + " user deleted from dashboard ";
    }
}
