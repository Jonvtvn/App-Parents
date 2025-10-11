package com.app_parents_backend.backend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_parents_backend.backend.models.UserChildren;
import com.app_parents_backend.backend.models.UserParents;
import com.app_parents_backend.backend.repositories.UserChildrenRepository;
import com.app_parents_backend.backend.repositories.UserParentsRepository;



@Service
public class UserService {

    @Autowired
    private UserChildrenRepository userChildrenRepository;

    @Autowired
    private UserParentsRepository userParentsRepository;
    
    public ArrayList<UserChildren> obtenerUserChildren(){
        return (ArrayList<UserChildren>) userChildrenRepository.findAll();
    }

    public UserChildren guardaUserChildren(UserChildren usuario){
        return userChildrenRepository.save(usuario);
    }

    public ArrayList<UserParents> obtenerUserParents(){
        return (ArrayList<UserParents>) userParentsRepository.findAll();
    }

    public UserParents guardaUserParents(UserParents usuario){
        return userParentsRepository.save(usuario);
    }
}