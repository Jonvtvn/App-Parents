package com.app_parents_backend.backend.controllers;

import com.app_parents_backend.backend.models.LoginRequest;
import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
                user.getAddress(), user.getNumber(), user.isStateFamily(), user.getBirthDate());
    }
}
