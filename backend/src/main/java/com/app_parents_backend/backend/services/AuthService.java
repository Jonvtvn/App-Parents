package com.app_parents_backend.backend.services;

import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.repositories.UserRepository;
import com.app_parents_backend.backend.config.JwtUtil;

import java.util.Date;

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
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generateToken(username);
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

        User user = new User(username, encoder.encode(password), name, email, address, number, state_family,
                birth_date);

        return userRepository.save(user);
    }
}
