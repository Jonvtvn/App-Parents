package com.app_parents_backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app_parents_backend.backend.models.Task;

import java.util.List;

import com.app_parents_backend.backend.models.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByReceiverUsername(User receiverUsername);

    List<Task> findBySenderUsername(User senderUsername);

    List<Task> findBySenderUsernameAndReceiverUsername(User senderUsername, User receiverUsername);
}