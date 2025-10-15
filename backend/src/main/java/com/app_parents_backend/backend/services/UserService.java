package com.app_parents_backend.backend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.repositories.UserRepository;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> obtenerUser(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User guardaUser(User usuario){
        return userRepository.save(usuario);
    }


}