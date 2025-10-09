// package com.app_parents_backend.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// // 🔥 Forma actual recomendada para desactivar CSRF
// .csrf(csrf -> csrf.disable())

// // 👇 Configura las reglas de autorización
// .authorizeHttpRequests(auth -> auth
// .requestMatchers("/api/public/**").permitAll()
// .anyRequest().authenticated())

// // ✅ Autenticación básica (user + password generada)
// .httpBasic(httpBasic -> {
// });

// return http.build();
// }
// }
