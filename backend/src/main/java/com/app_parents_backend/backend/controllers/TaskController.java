package com.app_parents_backend.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.app_parents_backend.backend.models.Task;
import com.app_parents_backend.backend.repositories.UserRepository;
import com.app_parents_backend.backend.services.TaskService;

import java.util.List;

import com.app_parents_backend.backend.models.User;

@RestController
@RequestMapping("/api/messages")
public class TaskController {

    @Autowired
    private TaskService TaskService;
    private UserRepository userRepository;

    // Enviar mensaje
    @PostMapping("/send")
    public Task sendMessage(@RequestBody Task request, Authentication authentication) {
        String senderUsername = authentication.getName(); // usuario logeado
        User sender = userRepository.findByUsername(senderUsername)  // => Validamos que el usuario exista 
            .orElseThrow(() -> new RuntimeException("Remitente no encontrado"));
        User receiver = userRepository.findByUsername(request.getReceiverUsername().toString())// => Validamos que el usuario exista 
            .orElseThrow(() -> new RuntimeException("Receptor no encontrado"));
        request.setSenderUsername(sender);
        request.setReceiverUsername(receiver);
        return TaskService.saveMessage(request);
    }

    // Ver mensajes recibidos
    @GetMapping("/received")
    public List<Task> getReceivedMessages(Authentication authentication) {
        String username = authentication.getName();
        User username_User = userRepository.findByUsername(username)  // => Validamos que el usuario exista 
            .orElseThrow(() -> new RuntimeException("Remitente no encontrado"));
        return TaskService.getMessagesReceived(username_User);
    }

    // Ver mensajes enviados
    @GetMapping("/sent")
    public List<Task> getSentMessages(Authentication authentication) {
        String username = authentication.getName();
        User username_User = userRepository.findByUsername(username)  // => Validamos que el usuario exista 
            .orElseThrow(() -> new RuntimeException("Remitente no encontrado"));
        return TaskService.getMessagesSent(username_User);
    }

    // Ver conversación con otro usuario
    @GetMapping("/conversation/{receiverUsername}")
    public List<Task> getConversation(@PathVariable User receiverUsername, Authentication authentication) {
        String senderUsername = authentication.getName();
        User username_User = userRepository.findByUsername(senderUsername)  // => Validamos que el usuario exista 
            .orElseThrow(() -> new RuntimeException("Remitente no encontrado"));
        return TaskService.getConversation(username_User, receiverUsername);
    }
}