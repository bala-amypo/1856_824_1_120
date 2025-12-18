package com.example.demo.entity;

import jakarta.persistence.

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


}