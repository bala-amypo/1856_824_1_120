package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount register(UserAccount user) {

        if (userAccountRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // default role if not set
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }

        return userAccountRepository.save(user);
    }

    @Override
    public String login(String username, String password) {

        UserAccount user = userAccountRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful";
    }
}
