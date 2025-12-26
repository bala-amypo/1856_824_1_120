package com.example.demo.repository;

import com.example.demo.entity.RateLimitEnforcement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RateLimitEnforcementRepository
        extends JpaRepository<RateLimitEnforcement, Long> {

    List<RateLimitEnforcement> findByApiKey_Id(Long id);
}
