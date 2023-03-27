package com.example.userserver.facade;

import com.example.userserver.entity.User;
import com.example.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    public User createUser(User user) {
        return userService.saveUser(user);
    }

    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public Optional<User> getUserById(Long id) {
        return userService.getUserById(id);
    }

    public User updateUser(Long id, User user) {
        return userService.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    public Optional<User> getUserByUUID(String username) {
        return userService.getUserByUUID(username);
    }
}
