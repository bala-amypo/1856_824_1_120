package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.ApiUsageLog;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.ApiUsageLogRepository;
import com.example.demo.service.ApiUsageLogService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    @Autowired
    private ApiUsageLogRepository logRepository;

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Override
    public ApiUsageLog logUsage(ApiUsageLog log) {
        if (log.getTimestamp().after(new Timestamp(System.currentTimeMillis()))) {
            throw new RuntimeException("Timestamp cannot be in future");
        }
        return logRepository.save(log);
    }

    @Override
    public List<ApiUsageLog> getUsageForApiKey(Long keyId) {
        ApiKey key = apiKeyRepository.findById(keyId)
                .orElseThrow(() -> new RuntimeException("ApiKey not found"));

        return logRepository.findByApiKey(key);
    }

    @Override
    public List<ApiUsageLog> getUsageForToday(Long keyId) {
        return getUsageForApiKey(keyId);
    }

    @Override
    public Long countRequestsToday(Long keyId) {
        return (long) getUsageForToday(keyId).size();
    }
}
