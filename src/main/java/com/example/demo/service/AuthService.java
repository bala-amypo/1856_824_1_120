package com.example.demo.service;
import com.example.demo.entity.UserAccount;
import jakarta.persistence.sevice;

@Service
public interface AuthService{
    public UserAccount register(RegisterRequestDto request);

    public UserAccount login(AuthRequestDto request);
}