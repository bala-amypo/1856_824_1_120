package com.example.demo.repository;

import com.example.demo.entity.KeyExemption;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyExemptionRepository
        extends JpaRepository<KeyExemption, Long> {

    Optional<KeyExemption> findByApiKey_Id(Long id);
}
