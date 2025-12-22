package com.example.demo.service;
import com.example.demo.entity.ApiKey;
import jakarta.persistence.Service;


public interface ApiKeyService{
     ApiKey createApiKey(ApiKey key);

     ApiKey updateApiKey(Long id, ApiKey key);

     ApiKey getApiKeyById(Long id);

     ApiKey getApiKeyByValue(String keyValue);

     ApiKey getAllKeys();

     ApiKey deactivateApiKey(Long id);

    
    
}