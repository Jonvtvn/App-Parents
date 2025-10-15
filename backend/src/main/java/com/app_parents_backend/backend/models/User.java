package com.app_parents_backend.backend.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
@Table(name = "User")
public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true,nullable=false)
    private Long id;
    private String username;
    private String nombre;
    private String password;
    private String email;
    private String address;
    private Integer numero;
    private boolean state_family; // True = Adult , False = Children
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //GET
    public Long getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return address;
    }
    public Integer getNumero(){
        return numero;
    }
    public boolean getState_family(){
        return state_family;
    }
    public Date getFecha_nacimiento(){
        return fecha_nacimiento;
    }


    //SET

    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public void setState_family(boolean state_family) {
        this.state_family = state_family;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}