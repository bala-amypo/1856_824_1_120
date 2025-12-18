package com.example.demo.entity;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;




@Entity
public class ApiUsageLog {

    @PerPersist
    public void onCreate(){
    createdAt = new 
    Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String apiKey;
    private String endpoint;
    @Timestamp
    private Timestamp timestamp;

    
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

    
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public ApiUsageLog(Long id, String apiKey, Timestamp endpoint, Timestamp timestamp ){
        this.id=id;
        this.apiKey=apiKey;
        this.endpoint=endpoint;
        this.timestamp=timestamp;
    }
    public ApiUsageLog(){

    }
}