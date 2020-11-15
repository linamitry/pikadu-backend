package com.service.pikadu.controller;

import com.service.pikadu.exception.UserNotFoundException;
import com.service.pikadu.model.User;
import com.service.pikadu.request.LoginRequest;
import com.service.pikadu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return service.login(request)
                .orElseThrow(() -> new UserNotFoundException(String.format("User '%s'", request.getEmail())));
    }

    @PostMapping("/registration")
    public User registration(@RequestBody User request) {
        return service.registration(request);
    }

    @DeleteMapping()
    public void delete() {
        service.removeAll();
    }

    @GetMapping()
    public User get(Long id) {
        return service.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User '%s'", id)));
    }
}
