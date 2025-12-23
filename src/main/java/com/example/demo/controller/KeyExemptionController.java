package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.KeyExemption;
import com.example.demo.service.KeyExemptionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/key-exemptions")
@Tag(name = "Key Exemptions")
public class KeyExemptionController {

    @Autowired
    private KeyExemptionService exemptionService;

    @PostMapping
    public KeyExemption createExemption(@RequestBody KeyExemption exemption) {
        return exemptionService.createExemption(exemption);
    }

    @PutMapping("/{id}")
    public KeyExemption updateExemption(
            @PathVariable Long id,
            @RequestBody KeyExemption exemption) {
        return exemptionService.updateExemption(id, exemption);
    }

    @GetMapping("/key/{keyId}")
    public KeyExemption getExemptionByKey(@PathVariable Long keyId) {
        return exemptionService.getExemptionByKey(keyId);
    }

    @GetMapping
    public List<KeyExemption> getAllExemptions() {
        return exemptionService.getAllExemptions();
    }
}
