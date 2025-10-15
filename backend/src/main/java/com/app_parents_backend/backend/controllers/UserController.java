package com.app_parents_backend.backend.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app_parents_backend.backend.services.UserService;
import com.app_parents_backend.backend.models.User;


@RestController
@RequestMapping("/User")
public class UserController{
    @Autowired
    UserService userService;

    @GetMapping()
    public  ArrayList<User> obtenerUser(){
        return userService.obtenerUser();
    }

    @PostMapping()
    public User guardaUser(@RequestBody User usuario){
        return this.userService.guardaUser(usuario);
    }
}