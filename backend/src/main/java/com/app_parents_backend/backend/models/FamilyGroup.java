package com.app_parents_backend.backend.models;

import java.util.ArrayList;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "family_group")
public class FamilyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameGroup; // Nombre del grupo
    private String password; // contraseña del grupo

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();

    // El padre que creó el grupo
    @ManyToOne
    @JoinColumn(name = "admin_id")

    private User admin;

    // Lista de usuarios padres
    private ArrayList<User> listaUser;

    public FamilyGroup() {
        // Inicializar las listas para evitar NullPointerException
        this.listaUser = new ArrayList<>();
    }

    // === Getters y Setters ===

    public Long getId() {
        return id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public ArrayList<User> getListaUser() {
        return listaUser;
    }

    public void setListaUser(ArrayList<User> listaUser) {
        this.listaUser = listaUser;
    }

}