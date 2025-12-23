package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.entity.ApiKey;

import java.util.List;

public interface RateLimitEnforcementRepository
        extends JpaRepository<RateLimitEnforcement, Long> {

    List<RateLimitEnforcement> findByApiKey(ApiKey apiKey);
}
