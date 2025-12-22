package com.example.demo.controller;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.service.ApiUsageLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage-logs")
@Tag(name = "API Usage Logs")
public class ApiUsageLogController {

    private final ApiUsageLogService usageLogService;

    public ApiUsageLogController(ApiUsageLogService usageLogService) {
        this.usageLogService = usageLogService;
    }

    @PostMapping
    public ApiUsageLog logUsage(@RequestBody ApiUsageLog log) {
        return usageLogService.logUsage(log);
    }

    @GetMapping("/key/{keyId}")
    public List<ApiUsageLog> getUsageForKey(@PathVariable Long keyId) {
        return usageLogService.getUsageForApiKey(keyId);
    }

    @GetMapping("/key/{keyId}/today")
    public List<ApiUsageLog> getTodayUsage(@PathVariable Long keyId) {
        return usageLogService.getUsageForToday(keyId);
    }

    @GetMapping("/key/{keyId}/count-today")
    public Long countToday(@PathVariable Long keyId) {
        return usageLogService.countRequestsToday(keyId);
    }
}
