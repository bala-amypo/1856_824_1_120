package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/api-keys")
@Tag(name = "API Keys")
public class ApiKeyController {

    @Autowired
    private ApiKeyService apiKeyService;

    @PostMapping
    public ApiKey createApiKey(@RequestBody ApiKey key) {
        return apiKeyService.createApiKey(key);
    }

    @PutMapping("/{id}")
    public ApiKey updateApiKey(@PathVariable Long id, @RequestBody ApiKey key) {
        return apiKeyService.updateApiKey(id, key);
    }

    @GetMapping("/{id}")
    public ApiKey getApiKeyById(@PathVariable Long id) {
        return apiKeyService.getApiKeyById(id);
    }

    @GetMapping
    public List<ApiKey> getAllApiKeys() {
        return apiKeyService.getAllApiKeys();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateApiKey(@PathVariable Long id) {
        apiKeyService.deactivateApiKey(id);
    }
}
