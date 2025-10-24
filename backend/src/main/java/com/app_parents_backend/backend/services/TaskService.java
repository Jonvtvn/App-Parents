package com.app_parents_backend.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app_parents_backend.backend.models.Task;
import com.app_parents_backend.backend.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveMessage(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getMessagesReceived(String username) {
        return taskRepository.findByReceiverUsername(username);
    }

    public List<Task> getMessagesSent(String username) {
        return taskRepository.findBySenderUsername(username);
    }

    public List<Task> getConversation(String sender, String receiver) {
        return taskRepository.findBySenderUsernameAndReceiverUsername(sender, receiver);
    }
}
