package com.example.demo.service.impl;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.QuotaPlanService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuotaPlanServiceImpl implements QuotaPlanService {

    private final QuotaPlanRepository quotaPlanRepository;

    public QuotaPlanServiceImpl(QuotaPlanRepository quotaPlanRepository) {
        this.quotaPlanRepository = quotaPlanRepository;
    }

    @Override
    public QuotaPlan createQuotaPlan(QuotaPlan plan) {

        if (plan.getDailyLimit() == null || plan.getDailyLimit() <= 0) {
            throw new BadRequestException("Daily limit must be greater than 0");
        }

        return quotaPlanRepository.save(plan);
    }

    @Override
    public QuotaPlan updateQuotaPlan(Long id, QuotaPlan plan) {

        QuotaPlan existing = quotaPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuotaPlan not found"));

        if (plan.getDailyLimit() <= 0) {
            throw new BadRequestException("Daily limit must be greater than 0");
        }

        existing.setPlanName(plan.getPlanName());
        existing.setDailyLimit(plan.getDailyLimit());
        existing.setDescription(plan.getDescription());
        existing.setActive(plan.getActive());

        return quotaPlanRepository.save(existing);
    }

    @Override
    public QuotaPlan getQuotaPlanById(Long id) {
        return quotaPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuotaPlan not found"));
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
