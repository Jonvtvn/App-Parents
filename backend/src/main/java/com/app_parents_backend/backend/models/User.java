package com.app_parents_backend.backend.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private boolean stateFamily; // true = Adulto, false = Niño

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    // Relación ManyToMany con FamilyGroup
    @ManyToMany(mappedBy = "miembros")
    private Set<FamilyGroup> grupos = new HashSet<>();

    // ----- Constructores -----

    public User() {}

    // Registro
    public User(String username, String password, String name, String email,
                String address, Integer number, boolean stateFamily, Date birthDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.number = number;
        this.stateFamily = stateFamily;
        this.birthDate = birthDate;
    }

    // Login
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // ----- Getters y Setters -----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public boolean isStateFamily() { return stateFamily; }
    public void setStateFamily(boolean stateFamily) { this.stateFamily = stateFamily; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public Set<FamilyGroup> getGrupos() { return grupos; }
    public void setGrupos(Set<FamilyGroup> grupos) { this.grupos = grupos; }
}
