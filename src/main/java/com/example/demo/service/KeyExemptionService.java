package com.example.demo.service;
import com.example.demo.entity.KeyExemption;
import jakarta.persistence.Service;


public interface KeyExemptionService{
     KeyExemption createExemption(KeyExemption exemption);

     KeyExemption updateExemption(Long Id, KeyExemption exemption);

     KeyExemption getExemptionByKey(Long apiKeyId);

     KeyExemption getAllExemption();

}