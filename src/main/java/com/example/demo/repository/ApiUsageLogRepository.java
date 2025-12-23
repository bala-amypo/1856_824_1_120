package com.example.demo.repository;

import com.example.demo.entity.ApiUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {

    List<ApiUsageLog> findByApiKeyId(Long apiKeyId);

    @Query("select l from ApiUsageLog l where l.apiKey.id = :keyId and date(l.timestamp) = current_date")
    List<ApiUsageLog> findTodayUsage(Long keyId);

    @Query("select count(l) from ApiUsageLog l where l.apiKey.id = :keyId and date(l.timestamp) = current_date")
    Long countTodayRequests(Long keyId);
}
