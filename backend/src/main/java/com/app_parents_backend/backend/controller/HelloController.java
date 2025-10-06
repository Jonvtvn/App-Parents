package com.app_parents_backend.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RestMapping("/api")
public class HelloController {

    @GetMapping("/prueba/hello")
    public String sayHello() {
        return "¡Hola desde el backend!";
    }
}