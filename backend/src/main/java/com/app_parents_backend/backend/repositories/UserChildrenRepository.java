package com.app_parents_backend.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app_parents_backend.backend.models.UserChildren;

@Repository
public interface UserChildrenRepository extends CrudRepository<UserChildren, Long> {
}
