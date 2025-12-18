package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;

@Entity
public class KeyExemption {

    @PrePersist
    public void onCreate() {
    this. = new 
    Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apiKey;

    private String notes;

    private Boolean unlimitedAccess;

    private Long temporaryExtensionLimit;

    private Timestamp validUntil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getUnlimitedAccess() {
        return unlimitedAccess;
    }

    public void setUnlimitedAccess(Boolean unlimitedAccess) {
        this.unlimitedAccess = unlimitedAccess;
    }

    public Long getTemporaryExtensionLimit() {
        return temporaryExtensionLimit;
    }

    public void setTemporaryExtensionLimit(Long temporaryExtensionLimit) {
        this.temporaryExtensionLimit = temporaryExtensionLimit;
    }

    public Timestamp getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Timestamp validUntil) {
        this.validUntil = validUntil;
    }

    public KeyExemption(Long id, String apiKey, String notes,
                        Boolean unlimitedAccess, Long temporaryExtensionLimit,
                        Timestamp validUntil) {
        this.id = id;
        this.apiKey = apiKey;
        this.notes = notes;
        this.unlimitedAccess = unlimitedAccess;
        this.temporaryExtensionLimit = temporaryExtensionLimit;
        this.validUntil = validUntil;
    }

    public KeyExemption() {

    }
}
