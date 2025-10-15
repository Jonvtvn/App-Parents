package com.app_parents_backend.backend.controllers;

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
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password) {
        return authService.register(username, password);
    }
}
