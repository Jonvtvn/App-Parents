package com.app_parents_backend.backend.services;

import com.app_parents_backend.backend.models.FamilyGroup;
import com.app_parents_backend.backend.models.User;
import com.app_parents_backend.backend.repositories.FamilyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyGroupService {

    @Autowired
    private FamilyGroupRepository familyGroupRepository;

    public List<FamilyGroup> getAllGroups() {
        return familyGroupRepository.findAll();
    }

    public Optional<FamilyGroup> getGroupById(Long id) {
        return familyGroupRepository.findById(id);
    }

    public FamilyGroup createGroup(FamilyGroup group) {
        if (familyGroupRepository.existsByNameGroup(group.getNameGroup())) {
            throw new RuntimeException("El grupo ya existe con ese nombre.");
        }
        return familyGroupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        familyGroupRepository.deleteById(id);
    }

    public FamilyGroup addUserToGroup(FamilyGroup group, User user) {
        group.getMiembros().add(user);
        return familyGroupRepository.save(group);
    }
}