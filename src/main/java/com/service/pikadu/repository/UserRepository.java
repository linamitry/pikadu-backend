package com.service.pikadu.repository;

import com.service.pikadu.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findUserByEmailAndPassword(String email, String password);
}
