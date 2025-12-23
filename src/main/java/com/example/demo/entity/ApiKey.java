package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String keyValue;

    private boolean active = true;

    @ManyToOne
    private QuotaPlan quotaPlan;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public QuotaPlan getQuotaPlan() {
        return quotaPlan;
    }

    public void setQuotaPlan(QuotaPlan quotaPlan) {
        this.quotaPlan = quotaPlan;
    }
}
