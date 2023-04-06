package com.example.userserver.controller;

import com.example.userserver.entity.User;
import com.example.userserver.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try { User createdUser = userFacade.createUser(user);  return new ResponseEntity<>(createdUser, HttpStatus.CREATED); } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> getUserByUUID(@PathVariable String uuid) {
        Optional<User> user = userFacade.getUserByUUID(uuid);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userFacade.getUserByUsername(username);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userFacade.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
