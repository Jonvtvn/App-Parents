package com.app_parents_backend.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_parents_backend.backend.models.Task;
import com.app_parents_backend.backend.repositories.TaskRepository;

import java.util.List;

import com.app_parents_backend.backend.models.User;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveMessage(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getMessagesReceived(User username) {
        return taskRepository.findByReceiverUsername(username);
    }

    public List<Task> getMessagesSent(User username) {
        return taskRepository.findBySenderUsername(username);
    }

    public List<Task> getConversation(User sender, User receiver) {
        return taskRepository.findBySenderUsernameAndReceiverUsername(sender, receiver);
    }
}
