package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.QuotaPlan;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.ApiKeyService;

import java.util.List;

public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    private final QuotaPlanRepository quotaPlanRepository;

    public ApiKeyServiceImpl(
            ApiKeyRepository apiKeyRepository,
            QuotaPlanRepository quotaPlanRepository) {

        this.apiKeyRepository = apiKeyRepository;
        this.quotaPlanRepository = quotaPlanRepository;
    }

    @Override
    public ApiKey createApiKey(ApiKey apiKey) {

        QuotaPlan plan = apiKey.getPlan();

        if (plan != null && Boolean.FALSE.equals(plan.getActive())) {
            throw new BadRequestException("Quota plan is inactive");
        }

        return apiKeyRepository.save(apiKey);
    }

    @Override
    public ApiKey updateApiKey(Long id, ApiKey apiKey) {

        ApiKey existing = apiKeyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));

        existing.setKeyValue(apiKey.getKeyValue());
        existing.setPlan(apiKey.getPlan());
        existing.setActive(apiKey.getActive());

        return apiKeyRepository.save(existing);
    }

    @Override
    public ApiKey getApiKeyById(Long id) {
        return apiKeyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
    }

    @Override
    public ApiKey getApiKeyByValue(String keyValue) {
        return apiKeyRepository.findByKeyValue(keyValue)
                .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
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
