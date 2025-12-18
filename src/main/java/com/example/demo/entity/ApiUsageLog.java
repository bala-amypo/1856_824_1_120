package com.example.demo.entity;

@Entity
public class ApiUsageLog{
    @Id
    @GenratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String apiKey;
    private String endpoint;
    private Timestamp timestamp;

}