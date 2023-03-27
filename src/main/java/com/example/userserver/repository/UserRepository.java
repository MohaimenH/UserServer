package com.example.userserver.repository;

import com.example.userserver.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUuid(String uuid);
    Optional<User> findByUsername(String username);
}