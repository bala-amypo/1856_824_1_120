package com.example.demo.entity;

import jakarta.presistence.Entity;
import jakarta.presistence.id;
import jakarta.presistence.GeneratedValue;
import jakarta.presistence.GenerationType;
import jakarta.presistence.Column;
import jakarta.presistence.ManyTo

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
}