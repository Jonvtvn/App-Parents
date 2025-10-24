package com.app_parents_backend.backend.repositories;

import com.app_parents_backend.backend.models.JoinRequest;
import com.app_parents_backend.backend.models.FamilyGroup;
import com.app_parents_backend.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinRequestRepository extends JpaRepository<JoinRequest, Long> {
    List<JoinRequest> findByGroup(FamilyGroup group);
    List<JoinRequest> findByUserRequest(User user);
}