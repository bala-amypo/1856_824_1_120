package com.example.demo.controller;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/api-keys")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @PostMapping
    public ApiKey create(@RequestBody ApiKey key) {
        return apiKeyService.createApiKey(key);
    }

    @PutMapping("/{id}")
    public ApiKey update(@PathVariable Long id, @RequestBody ApiKey key) {
        return apiKeyService.updateApiKey(id, key);
    }

    @GetMapping("/{id}")
    public ApiKey get(@PathVariable Long id) {
        return apiKeyService.getApiKeyById(id);
    }

    @GetMapping
    public List<ApiKey> list() {
        return apiKeyService.getAllApiKeys();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        apiKeyService.deactivateApiKey(id);
    }
}
