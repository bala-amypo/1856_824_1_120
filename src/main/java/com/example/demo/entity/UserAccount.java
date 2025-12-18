package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Entity
public class UserAccount {

    @PrePersist
    public void onCreate() {
        // default logic can be added if required
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;
    
    private String quotaPlans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getQuotaPlans() {
        return quotaPlans;
    }

    public void setQuotaPlans(String quotaPlans) {
        this.quotaPlans = quotaPlans;
    }

    public UserAccount(Long id, String email, String password,
                       String role, String quotaPlans) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.quotaPlans = quotaPlans;
    }

    public UserAccount() {

    }
}
