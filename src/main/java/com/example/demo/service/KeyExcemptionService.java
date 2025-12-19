package com.example.demo.service;
import com.example.demo.entity.KeyExemption;
import jakarta.persistence.service;


public interface KeyExcemptionService{
    public KeyExemption createExemption(KeyExemption exemption);

    public KeyExemption updateExemption(Long Id, KeyExcemption exemption);

    public KeyExemption getExemptionByKey(Long apiKeyId);

    public KeyExemption getAllExemption();

}