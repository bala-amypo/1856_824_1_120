package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.KeyExemption;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class KeyExemptionServiceImpl implements KeyExemptionService {

    private final KeyExemptionRepository exemptionRepository;
    private final ApiKeyRepository apiKeyRepository;

    public KeyExemptionServiceImpl(KeyExemptionRepository exemptionRepository,
                                   ApiKeyRepository apiKeyRepository) {
        this.exemptionRepository = exemptionRepository;
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public KeyExemption createExemption(KeyExemption exemption) {

        if (exemption.getTemporaryExtensionLimit() != null
                && exemption.getTemporaryExtensionLimit() < 0) {
            throw new BadRequestException("Invalid extension limit");
        }

        if (exemption.getValidUntil() != null
                && exemption.getValidUntil().isBefore(Instant.now())) {
            throw new BadRequestException("validUntil must be in the future");
        }

        ApiKey key = apiKeyRepository.findById(exemption.getApiKey().getId())
                .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));

        exemption.setApiKey(key);
        return exemptionRepository.save(exemption);
    }

    @Override
    public KeyExemption updateExemption(Long id, KeyExemption exemption) {

        KeyExemption existing = exemptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exemption not found"));

        existing.setNotes(exemption.getNotes());
        existing.setUnlimitedAccess(exemption.getUnlimitedAccess());
        existing.setTemporaryExtensionLimit(exemption.getTemporaryExtensionLimit());
        existing.setValidUntil(exemption.getValidUntil());

        return exemptionRepository.save(existing);
    }

    @Override
    public KeyExemption getExemptionByKey(Long apiKeyId) {
        return exemptionRepository.findByApiKey_Id(apiKeyId)
                .orElseThrow(() -> new ResourceNotFoundException("Exemption not found"));
    }

    @Override
    public List<KeyExemption> getAllExemptions() {
        return exemptionRepository.findAll();
    }
}
