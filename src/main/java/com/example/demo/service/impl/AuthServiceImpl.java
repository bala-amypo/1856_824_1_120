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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserAccountRepository userAccountRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {

        if (userAccountRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setActive(true);

        UserAccount saved = userAccountRepository.save(user);

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", saved.getRole());

        String token = jwtUtil.generateToken(claims, saved.getUsername());

        return new AuthResponseDto(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail(),
                saved.getRole(),
                token
        );
    }

    @Override
    public AuthResponseDto login(AuthRequestDto request) {

        UserAccount user = userAccountRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());

        String token = jwtUtil.generateToken(claims, user.getUsername());

        return new AuthResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                token
        );
    }
}
