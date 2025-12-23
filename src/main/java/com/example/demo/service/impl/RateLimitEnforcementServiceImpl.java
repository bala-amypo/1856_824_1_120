package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.RateLimitEnforcementRepository;
import com.example.demo.service.RateLimitEnforcementService;

import java.util.List;

@Service
public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

    @Autowired
    private RateLimitEnforcementRepository enforcementRepository;

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Override
    public RateLimitEnforcement createEnforcement(RateLimitEnforcement enforcement) {
        if (enforcement.getLimitExceededBy() <= 0) {
            throw new RuntimeException("Limit exceeded must be > 0");
        }
        return enforcementRepository.save(enforcement);
    }

    @Override
    public List<RateLimitEnforcement> getEnforcementsForKey(Long keyId) {
        ApiKey key = apiKeyRepository.findById(keyId)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));

        return enforcementRepository.findByApiKey(key);
    }

    @Override
    public RateLimitEnforcement getEnforcementById(Long id) {
        return enforcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enforcement not found"));
    }
}
