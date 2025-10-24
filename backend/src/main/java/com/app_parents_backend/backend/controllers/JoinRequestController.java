package com.app_parents_backend.backend.controllers;

import com.app_parents_backend.backend.models.FamilyGroup;
import com.app_parents_backend.backend.models.JoinRequest;
import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.services.JoinRequestService;
import com.app_parents_backend.backend.repositories.FamilyGroupRepository;
import com.app_parents_backend.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/join-requests")
public class JoinRequestController {

    @Autowired
    private JoinRequestService joinRequestService;

    @Autowired
    private FamilyGroupRepository familyGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/request/{groupId}")
    public JoinRequest requestJoin(@PathVariable Long groupId, Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        FamilyGroup group = familyGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        return joinRequestService.createRequest(group, user);
    }

    @PostMapping("/{requestId}/approve")
    public JoinRequest approveRequest(@PathVariable Long requestId) {
        return joinRequestService.updateStatus(requestId, JoinRequest.Status.APPROVED);
    }

    @PostMapping("/{requestId}/reject")
    public JoinRequest rejectRequest(@PathVariable Long requestId) {
        return joinRequestService.updateStatus(requestId, JoinRequest.Status.REJECTED);
    }

    @GetMapping("/my-requests")
    public List<JoinRequest> getUserRequests(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return joinRequestService.getRequestsByUser(user);
    }
}
