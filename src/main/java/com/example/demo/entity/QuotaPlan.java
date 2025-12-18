package com.example.demo.entity;



public class QuotaPlan{

    @Id
    @GeneratedValue()
    private Long id;
    @column(unique=true);
    private String planName;
    private Integer dailyLimit;
    private String description;
    private Boolean active;


}