package com.sara.rsp.entity;

import jakarta.persistence.*;

@Entity
public class AuthResponse {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String token;
    private String name;
    private String role;

    public AuthResponse() {
    }

    public AuthResponse(int id, String token, String name, String role) {
        this.id = id;
        this.token = token;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
