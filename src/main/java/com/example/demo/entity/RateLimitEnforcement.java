package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

import java.sql.Timestamp;

@Entity
public class RateLimitEnforcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apiKey;

    private Timestamp blockedAt;

    private Long limitExceededBy;

    private String message;

    
    @PrePersist
    public void validateLimit() {
        if (limitExceededBy == null || limitExceededBy < 1) {
            throw new IllegalArgumentException("limitExceededBy must be >= 1");
        }
    }

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

    public Timestamp getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Timestamp blockedAt) {
        this.blockedAt = blockedAt;
    }
    public Long getLimitExceededBy(){
        return limitExceededBy;
    }
    public void setLimitExceededBy(Long limitExceededBy){
        this.limitExceededBy=limitExceededBy;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public RateLimitEnforcement(Long id, String apiKey, Timestamp blockedAt,
                                Long limitExceededBy, String message) {
        this.id = id;
        this.apiKey = apiKey;
        this.blockedAt = blockedAt;
        this.limitExceededBy = limitExceededBy;
        this.message = message;
    }

    // Default Constructor
    public RateLimitEnforcement() {

    }
}
