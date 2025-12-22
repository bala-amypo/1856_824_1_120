package com.example.demo.service;
import com.example.demo.entity.UserAccount;
import jakarta.persistence.Service;


public interface AuthService{
     UserAccount register(RegisterRequestDto request);

     UserAccount login(AuthRequestDto request);
}