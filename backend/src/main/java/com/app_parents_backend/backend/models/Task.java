package com.app_parents_backend.backend.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private User senderUsername;
    private User receiverUsername;

    @Column(length = 500)
    private String textContent;
    private String imgBase64Content;

    @Column(length = 500)
    private String textAnswer;
    private String imgAnswerBase64;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt = new Date();

    @Enumerated(EnumType.STRING)
    private Status statusTask = Status.SENT;

    

    public enum Status {
        SENT,
        PENDING,
        COMPLETED
        
    }
    // builders
    public Task(){}

    // builders Create task
    public Task(User senderUsername, User receiverUsername, String textContent, String imgBase64Content ) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.textContent = textContent;
        this.imgBase64Content = imgBase64Content;
        this.sentAt = new Date();
    }
    
    // Get and Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public User getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(User senderUsername) {
        this.senderUsername = senderUsername;
    }

    public User getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(User receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    public Status getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(Status statusTask) {
        this.statusTask = statusTask;
    }
    
    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
    
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getImgBase64Content() {
        return imgBase64Content;
    }

    public void setImgBase64Content(String imgBase64Content) {
        this.imgBase64Content = imgBase64Content;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public String getImgAnswerBase64() {
        return imgAnswerBase64;
    }

    public void setImgAnswerBase64(String imgAnswerBase64) {
        this.imgAnswerBase64 = imgAnswerBase64;
    }
   

}