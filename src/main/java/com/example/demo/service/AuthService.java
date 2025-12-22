package com.example.demo.service;

import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;

public interface AuthService {

    void register(RegisterRequestDto request);

    AuthResponseDto login(AuthRequestDto request);
}
