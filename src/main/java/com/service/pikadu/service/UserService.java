package com.service.pikadu.service;

import com.service.pikadu.model.User;
import com.service.pikadu.repository.UserRepository;
import com.service.pikadu.request.LoginRequest;
import com.service.pikadu.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final SequenceGeneratorService sequenceGenerator;

    public Optional<User> login(LoginRequest request) {
        return repository.findUserByEmailAndPassword(request.email, request.password);
    }

    public User registration(RegistrationRequest request) {
        var user = new User(request.email, request.password, request.displayName);
        user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        return repository.save(user);
    }

    public void removeAll() {
        repository.deleteAll();
    }

}
