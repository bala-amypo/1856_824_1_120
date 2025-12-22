package com.example.demo.service;
import com.example.demo.entity.ApiUsageLog;
import jakarta.persistence.Service;


public interface ApiUsageLogService{
     ApiUsageLog logUsage(ApiUsageLog Log);

     ApiUsageLog getUsageForApiKey( Long keyId);

     ApiUsageLog getUsageForToday(Long KeyId);

     ApiUsageLog countRequestsToday(Long keyId);
    
}