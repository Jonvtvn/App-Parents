package com.app_parents_backend.backend.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "join_requests")
public class JoinRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Grupo al que se quiere unir
    @ManyToOne
    @JoinColumn(name = "group_id")
    private FamilyGroup group;

    // user que solicita (opcional)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userRequest;

    // Estado de la solicitud: PENDING / APPROVED / REJECTED
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate = new Date();

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    // Getters y Setters
    public Long getId() { return id; }
    public FamilyGroup getGroup() { return group; }
    public void setGroup(FamilyGroup group) { this.group = group; }

    public User getuserRequest() { return userRequest; }
    public void setuserRequest(User userRequest) { this.userRequest = userRequest; }


    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Date getRequestDate() { return requestDate; }
}