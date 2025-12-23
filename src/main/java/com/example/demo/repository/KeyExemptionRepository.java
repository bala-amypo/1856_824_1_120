package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.KeyExemption;
import com.example.demo.entity.ApiKey;

import java.util.Optional;

public interface KeyExemptionRepository extends JpaRepository<KeyExemption, Long> {

    Optional<KeyExemption> findByApiKey(ApiKey apiKey);
}
