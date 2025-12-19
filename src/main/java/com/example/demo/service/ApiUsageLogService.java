package com.example.demo.service;
import com.example.demo.entity.ApiUsageLog;
import jakarta.persistence.service;

@Service
public interface ApiUsageLogService{
    public ApiUsageLog logUsage(ApiUsageLog Log);

    public ApiUsageLog getUsageForApiKey( Long keyId);

    public ApiUsageLog getUsageForToday(Long KeyId);

    public ApiUsageLog countRequestsToday(Long keyId);
    
}