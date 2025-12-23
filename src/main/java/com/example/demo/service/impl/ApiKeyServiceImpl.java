package com.example.demo.service.imp;

import com.example.demo.entity.ApiKey;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository repo;

    public ApiKeyServiceImpl(ApiKeyRepository repo) {
        this.repo = repo;
    }

    @Override
    public ApiKey createApiKey(ApiKey key) {
        if (key.getQuotaPlan() == null || !key.getQuotaPlan().getActive()) {
            throw new BadRequestException("Plan is inactive");
        }
        return repo.save(key);
    }

    @Override
    public ApiKey updateApiKey(Long id, ApiKey key) {
        ApiKey existing = getApiKeyById(id);
        existing.setName(key.getName());
        existing.setQuotaPlan(key.getQuotaPlan());
        return repo.save(existing);
    }

    @Override
    public ApiKey getApiKeyById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("API Key not found"));
    }

    @Override
    public ApiKey getApiKeyByValue(String keyValue) {
        return repo.findByKeyValue(keyValue)
                .orElseThrow(() -> new ResourceNotFoundException("API Key not found"));
    }

    @Override
    public List<ApiKey> getAllApiKeys() {
        return repo.findAll();
    }

    @Override
    public void deactivateApiKey(Long id) {
        ApiKey key = getApiKeyById(id);
        key.setActive(false);
        repo.save(key);
    }
}
