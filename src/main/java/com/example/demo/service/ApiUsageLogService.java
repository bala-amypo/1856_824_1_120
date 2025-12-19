package com.example.demo.service;
import com.example.demo.entity.ApiUsageLog;
import jakarta.persistence.service;


public interface ApiUsageLogService{
    public ApiUsageLog logUsage(ApiUsageLog Log);

    public ApiUsageLog getUsageForApiKey( Long keyId);

    public ApiUsageLog getApiKeyById(Long id);

    public ApiUsageLog getApiKeyByValue(String keyValue);

    public ApiUsageLog getAllKeys();

    public ApiUsageLog deactivateApiKey(Long id);
    
}