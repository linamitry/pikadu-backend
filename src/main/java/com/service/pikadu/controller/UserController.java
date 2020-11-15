package com.service.pikadu.controller;

import com.service.pikadu.exception.UserNotFoundException;
import com.service.pikadu.model.User;
import com.service.pikadu.request.LoginRequest;
import com.service.pikadu.request.RegistrationRequest;
import com.service.pikadu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/login")
    public User login(LoginRequest request) {
        return service.login(request)
                .orElseThrow(() -> new UserNotFoundException(String.format("User '%s'", request.email)));
    }

    @PostMapping("/registration")
    public User registration(RegistrationRequest request) {
        return service.registration(request);
    }

    @DeleteMapping()
    public void delete() {
        service.removeAll();
    }
}
