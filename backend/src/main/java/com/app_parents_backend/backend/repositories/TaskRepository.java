package com.app_parents_backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app_parents_backend.backend.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByReceiverUsername(String receiverUsername);

    List<Task> findBySenderUsername(String senderUsername);

    List<Task> findBySenderUsernameAndReceiverUsername(String senderUsername, String receiverUsername);
}