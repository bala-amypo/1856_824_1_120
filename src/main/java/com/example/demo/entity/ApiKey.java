package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;


@Entity
public class ApiKey{

    @Id
    @GeneratedValue(strategy=GenerationType.INDENTITY)
    private Long id;
    @Column(unique=true)
    private String keyValue;
    private Long ownerld;
    @ManyToOne
    private QuotaPlan plan;
    private Boolean active = true;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getKeyValue(){
        return keyValue;
    }
    public void setKeyvalue(String keyValue){
        this.keyValue=keyValue;
    }
    public Long getOwnerld(){
        return ownerld;
    }
    public void setOwnerld(Long ownerld){
        this.ownerld=ownerld;
    }
    public QuotaPlan getPlan(){
        return plan;
    }
    public void setPlan(QuotaPlan plan){
        this.plan=plan;
    }
    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }
    public Timestamp getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt){
        this.createdAt=createdAt;
    }
    public Timestamp getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt){
        this.updatedAt=updatedAt;
    }
    public ApiKey(Long id, String keyValue, Long ownerld, QuotaPlan plan, Boolean active, Timestamp createdAt, Timestamp updatedAt){
        this.id=id;
        this.keyValue=keyValue;
        this.ownerld=ownerld;
        this.plan=plan;
        this.active=active;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }
    public ApiKey(){
        
    }

}
