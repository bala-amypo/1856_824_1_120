package com.example.demo.dto;

public class AuthResponseDto {

    private Long userId;
    private String username;
    private String email;
    private String token;
    private String message;

    public AuthResponseDto() {
    }

    public AuthResponseDto(Long userId, String username, String email, String token, String message) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.token = token;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
