package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.QuotaPlan;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.ApiKeyService;

import java.util.List;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Autowired
    private QuotaPlanRepository quotaPlanRepository;

    @Override
    public ApiKey createApiKey(ApiKey key) {
        QuotaPlan plan = key.getPlan();

        if (plan != null && plan.getActive() == false) {
            throw new RuntimeException("Plan is inactive");
        }

        return apiKeyRepository.save(key);
    }

    @Override
    public ApiKey updateApiKey(Long id, ApiKey key) {
        ApiKey existing = apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));

        existing.setKeyValue(key.getKeyValue());
        existing.setPlan(key.getPlan());
        existing.setActive(key.getActive());

        return apiKeyRepository.save(existing);
    }

    @Override
    public ApiKey getApiKeyById(Long id) {
        return apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));
    }

    @Override
    public ApiKey getApiKeyByValue(String keyValue) {
        return apiKeyRepository.findByKeyValue(keyValue)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));
    }

    @Override
    public List<ApiKey> getAllApiKeys() {
        return apiKeyRepository.findAll();
    }

    @Override
    public void deactivateApiKey(Long id) {
        ApiKey key = getApiKeyById(id);
        key.setActive(false);
        apiKeyRepository.save(key);
    }
}
