package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.QuotaPlanService;

import java.util.List;

@Service
public class QuotaPlanServiceImpl implements QuotaPlanService {

    @Autowired
    private QuotaPlanRepository quotaPlanRepository;

    @Override
    public QuotaPlan createQuotaPlan(QuotaPlan plan) {
        if (plan.getDailyLimit() <= 0) {
            throw new RuntimeException("Daily limit must be greater than 0");
        }
        return quotaPlanRepository.save(plan);
    }

    @Override
    public QuotaPlan updateQuotaPlan(Long id, QuotaPlan plan) {
        QuotaPlan existing = quotaPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuotaPlan not found"));

        existing.setPlanName(plan.getPlanName());
        existing.setDailyLimit(plan.getDailyLimit());
        existing.setDescription(plan.getDescription());
        existing.setActive(plan.getActive());

        return quotaPlanRepository.save(existing);
    }

    @Override
    public QuotaPlan getQuotaPlanById(Long id) {
        return quotaPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuotaPlan not found"));
    }

    @Override
    public List<QuotaPlan> getAllPlans() {
        return quotaPlanRepository.findAll();
    }

    @Override
    public void deactivateQuotaPlan(Long id) {
        QuotaPlan plan = getQuotaPlanById(id);
        plan.setActive(false);
        quotaPlanRepository.save(plan);
    }
}
