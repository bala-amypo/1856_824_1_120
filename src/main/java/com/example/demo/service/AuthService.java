package com.example.demo.service;
import com.example.demo.entity.UserAccount;
import jakarta.persistence.sevice;

public interface AuthService{
    public UserAccount register(RegisterRequestDto request);
}