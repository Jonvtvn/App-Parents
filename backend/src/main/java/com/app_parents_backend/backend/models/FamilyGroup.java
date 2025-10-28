package com.app_parents_backend.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "family_group")
public class FamilyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nameGroup;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    // Admin del grupo
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    // Miembros del grupo
    @ManyToMany
    @JoinTable(
        name = "group_users",
        joinColumns = @JoinColumn(name = "group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> miembros = new HashSet<>();

    // ----- Constructores -----

    public FamilyGroup() {}

    public FamilyGroup(User admin, String nameGroup, String password) {
        this.admin = admin;
        this.nameGroup = nameGroup;
        this.password = password;
        this.miembros.add(admin); // El creador siempre es miembro
    }

    // ----- Getters y Setters -----

    public Long getId() { return id; }

    public String getNameGroup() { return nameGroup; }
    public void setNameGroup(String nameGroup) { this.nameGroup = nameGroup; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getDateCreation() { return dateCreation; }

    public User getAdmin() { return admin; }
    public void setAdmin(User admin) { this.admin = admin; }

    public Set<User> getMiembros() { return miembros; }
    public void setMiembros(Set<User> miembros) { this.miembros = miembros; }

    public void agregarMiembro(User user) {
        this.miembros.add(user);
    }
}
