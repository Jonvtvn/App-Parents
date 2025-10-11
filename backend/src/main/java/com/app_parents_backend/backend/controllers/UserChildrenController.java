package com.app_parents_backend.backend.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app_parents_backend.backend.services.UserService;
import com.app_parents_backend.backend.models.UserChildren;


@RestController
@RequestMapping("/UserChildren")
public class UserChildrenController{
    @Autowired
    UserService userService;

    @GetMapping()
    public  ArrayList<UserChildren> obtenerUserChildren(){
        return userService.obtenerUserChildren();
    }

    @PostMapping()
    public UserChildren guardaUserChildren(@RequestBody UserChildren usuario){
        return this.userService.guardaUserChildren(usuario);
    }
}