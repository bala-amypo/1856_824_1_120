package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserAccountRepository userAccountRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {

        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {

        if (userAccountRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // ❌ NO setActive() — not present in entity

        UserAccount saved = userAccountRepository.save(user);

        Map<String, Object> claims = new HashMap<>();
        String token = jwtUtil.generateToken(claims, saved.getEmail());

        return new AuthResponseDto(
                saved.getId(),
                saved.getEmail(),
                saved.getEmail(),
                token,
                "Registration successful"
        );
    }

    @Override
    public AuthResponseDto login(AuthRequestDto request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), // email
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new BadRequestException("Invalid credentials");
        }

        UserAccount user = userAccountRepository.findByEmail(request.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        Map<String, Object> claims = new HashMap<>();
        String token = jwtUtil.generateToken(claims, user.getEmail());

        return new AuthResponseDto(
                user.getId(),
                user.getEmail(),
                user.getEmail(),
                token,
                "Login successful"
        );
    }
}
