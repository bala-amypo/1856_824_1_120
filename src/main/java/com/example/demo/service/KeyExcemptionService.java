package com.example.demo.service;
import com.example.demo.entity.KeyExemption;
import jakarta.persistence.service;


public interface KeyExemptionService{
    public KeyExemption createExemption(KeyExemption exemption);

    public KeyExemption updateExemption(Long Id, KeyExemption exemption);

    public KeyExemption getEnforcementById(Long id);

}