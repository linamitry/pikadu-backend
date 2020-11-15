package com.service.pikadu.repository;

import com.service.pikadu.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    public Optional<User> findUserByEmailAndPassword(String email, String password);
}
