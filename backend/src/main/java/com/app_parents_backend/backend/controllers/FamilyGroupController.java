package com.app_parents_backend.backend.controllers;

import com.app_parents_backend.backend.models.FamilyGroup;
import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.services.FamilyGroupService;
import com.app_parents_backend.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class FamilyGroupController {

    @Autowired
    private FamilyGroupService familyGroupService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<FamilyGroup> getAllGroups() {
        return familyGroupService.getAllGroups();
    }

    @PostMapping("/create")
    public FamilyGroup createGroup(@RequestBody FamilyGroup group, Authentication authentication) {
        String username = authentication.getName();
        User admin = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        group.setAdmin(admin);
        return familyGroupService.createGroup(group);
    }

    @PostMapping("/{groupId}/addUser/{userId}")
    public FamilyGroup addUserToGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        FamilyGroup group = familyGroupService.getGroupById(groupId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return familyGroupService.addUserToGroup(group, user);
    }
}