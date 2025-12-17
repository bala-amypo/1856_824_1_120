package com.example.demo.entity;

import jakarta.presistence.Entity;
import jakarta.presistence.Id;
import jakarta.presistence.GeneratedValue;
import jakarta.presistence.GenerationType;
import jakarta.presistence.Column;
import jakarta.presistence.ManyToOne;
import jakarta.presistence.ManyToMany;

import java.util.Set;
import java.util.List;

@Entity
public class ApiKey{

    @Id
    @GeneratedValue(strategy=GenerationType.INDENTITY)
    private Long id;
    @Column(unique=true)
    private String keyValue;
    private Long ownerld;
    private String plan;
    private Boolean active;
    private =new createdAt;
    private =new updatedAt;

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
        
    }

}
