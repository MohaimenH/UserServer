package com.example.userserver.service;

import com.example.userserver.entity.User;
import com.example.userserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAddress(user.getAddress());
            existingUser.setCountry(user.getCountry());

            return userRepository.save(existingUser);
        } else {
            return userRepository.save(user);
        }
    }

    public Optional<User> getUserByUUID(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    public Optional<User> getUserByUsername(String uuid) {
        return userRepository.findByUsername(uuid);
    }
}
