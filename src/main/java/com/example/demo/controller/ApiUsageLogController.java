package com.example.demo.controller;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.service.ApiUsageLogService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usage-logs")
public class ApiUsageLogController {

    private final ApiUsageLogService usageService;

    public ApiUsageLogController(ApiUsageLogService usageService) {
        this.usageService = usageService;
    }

    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog log) {
        return usageService.logUsage(log);
    }

    @GetMapping("/key/{keyId}")
    public List<ApiUsageLog> getUsageByKey(@PathVariable Long keyId) {
        return usageService.getUsageForApiKey(keyId);
    }

    @GetMapping("/key/{keyId}/today")
    public List<ApiUsageLog> getUsageForToday(@PathVariable Long keyId) {
        return usageService.getUsageForToday(keyId);
    }

    @GetMapping("/key/{keyId}/count-today")
    public int countRequestsToday(@PathVariable Long keyId) {
        return usageService.countRequestsToday(keyId);
    }
}
