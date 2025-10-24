package com.app_parents_backend.backend.services;

import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.repositories.UserRepository;
import com.app_parents_backend.backend.config.JwtUtil;

import java.util.Date;

import com.google.gson.JsonObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {
        userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("token", jwtUtil.generateToken(username));
        return jsonObject.toString();
    }

    public User register(
            String username,
            String password,
            String name,
            String email,
            String address,
            Integer number,
            boolean state_family,
            Date birth_date) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Usuario ya existe");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalStateException("El usuario con este email ya existe");
        }

        User user = new User(username, encoder.encode(password), name, email, address, number, state_family,
                birth_date);

        return userRepository.save(user);
    }
}
