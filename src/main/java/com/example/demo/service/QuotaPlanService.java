package com.example.demo.service;
import com.example.demo.entity.QuotaPlan;
import jakarta.persistence.service;


public interface QuotaPlanService{
    public QuotaPlan createQuotaPlan(QuotaPlan plan);

    public QuotaPlan updateQuotaPlan(Long id, QuotaPlan plan);

    public QuotaPlan getQuotaPlanById(Long id);

    public QuotaPlan getAllPlans();

    public QuotaPlan deactivateQuotaPlan(Long id);
    
}