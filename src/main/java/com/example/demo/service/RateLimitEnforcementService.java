package com.example.demo.service;
import com.example.demo.entity.RateLimitEnforcement;
import jakarta.persistence.Service;


public interface RateLimitEnforcementService{
     RateLimitEnforcement createEnforcement(RateLimitEnforcement enforcement);

     RateLimitEnforcement getEnforcementsForKey(Long keyId);

     RateLimitEnforcement getEnforcementById(Long id);

}