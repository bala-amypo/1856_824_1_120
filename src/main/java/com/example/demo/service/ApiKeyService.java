package com.example.demo.service;
import com.example.demo.entity.ApiKey;
import jakarta.persistence.Service;

@Service
public interface ApiKeyService{
    public ApiKey createApiKey(ApiKey key);

    public ApiKey updateApiKey(Long id, ApiKey key);

    public ApiKey getApiKeyById(Long id);

    public ApiKey getApiKeyByValue(String keyValue);

    public ApiKey getAllKeys();

    public ApiKey deactivateApiKey(Long id);

    
    
}