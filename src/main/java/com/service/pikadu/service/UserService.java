package com.service.pikadu.service;

import com.service.pikadu.model.User;
import com.service.pikadu.repository.UserRepository;
import com.service.pikadu.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public Optional<User> login(LoginRequest user) {
        return repository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    public User registration(User user) {
        return repository.save(user);
    }

    public void removeAll() {
        repository.deleteAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
}
