package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.ApiKey;

public interface Rate extends JpaRepository<ApiKey, Long>{

}