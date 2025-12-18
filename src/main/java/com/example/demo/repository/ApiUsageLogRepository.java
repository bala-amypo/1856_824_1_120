package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.ApiUsageLog;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long>{

}