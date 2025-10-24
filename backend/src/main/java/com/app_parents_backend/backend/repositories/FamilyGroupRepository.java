package com.app_parents_backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app_parents_backend.backend.models.FamilyGroup;
import java.util.Optional;

@Repository
public interface FamilyGroupRepository extends JpaRepository<FamilyGroup, Long> {
    Optional<FamilyGroup> findByNameGroup(String nameGroup);
    boolean existsByNameGroup(String nameGroup);
}