package com.example.demo.service;
import com.example.demo.entity.UserAccount;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import java.util.List;


public interface AuthService{
     UserAccount register(RegisterRequestDto request);

     UserAccount login(AuthRequestDto request);
}