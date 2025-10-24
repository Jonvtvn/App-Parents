package com.app_parents_backend.backend.services;

import com.app_parents_backend.backend.models.JoinRequest;
import com.app_parents_backend.backend.models.JoinRequest.Status;
import com.app_parents_backend.backend.models.FamilyGroup;
import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.repositories.JoinRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinRequestService {

    @Autowired
    private JoinRequestRepository joinRequestRepository;


    public List<JoinRequest> getRequestsByGroup(FamilyGroup group) {
        return joinRequestRepository.findByGroup(group);
    }

    public List<JoinRequest> getRequestsByUser(User user) {
        return joinRequestRepository.findByUserRequest(user);
    }

    public JoinRequest createRequest(FamilyGroup group, User user) {
        JoinRequest request = new JoinRequest();
        request.setGroup(group);
        request.setuserRequest(user);
        request.setStatus(Status.PENDING);
        return joinRequestRepository.save(request);
    }

    public JoinRequest updateStatus(Long requestId, Status status) {
        JoinRequest req = joinRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        req.setStatus(status);
        return joinRequestRepository.save(req);
    }
}
