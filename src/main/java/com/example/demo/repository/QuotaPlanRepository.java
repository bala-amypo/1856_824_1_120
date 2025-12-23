package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.QuotaPlan;

import java.util.Optional;

public interface QuotaPlanRepository extends JpaRepository<QuotaPlan, Long> {

    Optional<QuotaPlan> findByPlanName(String planName);

    boolean existsByPlanName(String planName);
}
