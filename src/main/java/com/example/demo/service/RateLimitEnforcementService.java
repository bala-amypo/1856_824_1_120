package com.example.demo.service;
import com.example.demo.entity.RateLimitEnforcement;
import jakarta.persistence.service;


public interface RateLimitEnforcementService{
    public RateLimitEnforcement createEnforcement();

    public RateLimitEnforcement updateQuotaPlan(Long id, QuotaPlan plan);

    public RateLimitEnforcement getQuotaPlanById(Long id);

    public QuotaPlan getAllPlans();

    public QuotaPlan deactivateQuotaPlan(Long id);
    
}