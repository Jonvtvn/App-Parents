package com.app_parents_backend.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app_parents_backend.backend.models.UserParents;


@Repository
public interface UserParentsRepository extends CrudRepository<UserParents, Long> {
}