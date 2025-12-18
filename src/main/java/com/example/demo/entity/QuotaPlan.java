package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class QuotaPlan{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @column(unique=true);
    private String planName;
    private Integer dailyLimit;
    private String description;
    private Boolean active;


    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getPlanName(){
        return planName;
    }
    public void setPlanName(String planName){
        this.planName=planName;
    }
    public Integer getDailyLimit(){
        return dailyLimit;
    }
    public void setDailylimit(Integer dailyLimit){
        this.dailyLimit=dailyLimit;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public Boolean getActve(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }
    public QuotaPlan()

}