package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.service.ApiUsageLogService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/usage-logs")
@Tag(name = "API Usage Logs")
public class ApiUsageLogController {

    @Autowired
    private ApiUsageLogService usageLogService;

    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog log) {
        return usageLogService.logUsage(log);
    }

    @GetMapping("/key/{keyId}")
    public List<ApiUsageLog> getUsageForKey(@PathVariable Long keyId) {
        return usageLogService.getUsageForApiKey(keyId);
    }

    @GetMapping("/key/{keyId}/today")
    public List<ApiUsageLog> getUsageForToday(@PathVariable Long keyId) {
        return usageLogService.getUsageForToday(keyId);
    }

    @GetMapping("/key/{keyId}/count-today")
    public Long countRequestsToday(@PathVariable Long keyId) {
        return usageLogService.countRequestsToday(keyId);
    }
}
