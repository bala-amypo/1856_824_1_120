package com.example.demo.service;
import com.example.demo.entity.QuotaPlan;
import jakarta.persistence.Service;


public interface QuotaPlanService{
     QuotaPlan createQuotaPlan(QuotaPlan plan);

     QuotaPlan updateQuotaPlan(Long id, QuotaPlan plan);

     QuotaPlan getQuotaPlanById(Long id);

     QuotaPlan getAllPlans();

     QuotaPlan deactivateQuotaPlan(Long id);
    
}