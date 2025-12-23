package com.example.demo.service.imp;

import com.example.demo.entity.ApiKey;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public ApiKey createApiKey(ApiKey apiKey) {
        // No QuotaPlan object, plan is just a String
        return apiKeyRepository.save(apiKey);
    }

    @Override
    public ApiKey updateApiKey(Long id, ApiKey apiKey) {
        ApiKey existing = getApiKeyById(id);

        existing.setKeyValue(apiKey.getKeyValue());
        existing.setOwnerId(apiKey.getOwnerId());
        existing.setPlan(apiKey.getPlan());
        existing.setActive(apiKey.getActive());

        return apiKeyRepository.save(existing);
    }

    @Override
    public ApiKey getApiKeyById(Long id) {
        return apiKeyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("API Key not found with id " + id));
    }

    @Override
    public ApiKey getApiKeyByValue(String keyValue) {
        return apiKeyRepository.findByKeyValue(keyValue)
                .orElseThrow(() ->
                        new ResourceNotFoundException("API Key not found"));
    }

    @Override
    public List<ApiKey> getAllApiKeys() {
        return apiKeyRepository.findAll();
    }

    @Override
    public void deactivateApiKey(Long id) {
        ApiKey apiKey = getApiKeyById(id);
        apiKey.setActive(false);
        apiKeyRepository.save(apiKey);
    }
}
