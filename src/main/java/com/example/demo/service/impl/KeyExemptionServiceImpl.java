package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.KeyExemption;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;

import java.util.List;

@Service
public class KeyExemptionServiceImpl implements KeyExemptionService {

    @Autowired
    private KeyExemptionRepository exemptionRepository;

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Override
    public KeyExemption createExemption(KeyExemption exemption) {
        return exemptionRepository.save(exemption);
    }

    @Override
    public KeyExemption updateExemption(Long id, KeyExemption exemption) {
        KeyExemption existing = exemptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemption not found"));

        existing.setNotes(exemption.getNotes());
        existing.setUnlimitedAccess(exemption.getUnlimitedAccess());
        existing.setTemporaryExtensionLimit(exemption.getTemporaryExtensionLimit());
        existing.setValidUntil(exemption.getValidUntil());

        return exemptionRepository.save(existing);
    }

    @Override
    public KeyExemption getExemptionByKey(Long apiKeyId) {
        ApiKey key = apiKeyRepository.findById(apiKeyId)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));

        return exemptionRepository.findByApiKey(key)
                .orElseThrow(() -> new RuntimeException("Exemption not found"));
    }

    @Override
    public List<KeyExemption> getAllExemptions() {
        return exemptionRepository.findAll();
    }
}
