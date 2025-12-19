package com.example.demo.service;
import com.example.demo.entity.RateLimitEnforcement;
import jakarta.persistence.Service;

@Service
public interface RateLimitEnforcementService{
    public RateLimitEnforcement createEnforcement(RateLimitEnforcement enforcement);

    public RateLimitEnforcement getEnforcementsForKey(Long keyId);

    public RateLimitEnforcement getEnforcementById(Long id);

}