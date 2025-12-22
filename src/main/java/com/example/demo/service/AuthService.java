package com.example.demo.service;
import com.example.demo.entity.UserAccount;
import java.util.List;


public interface AuthService{
     UserAccount register(RegisterRequestDto request);

     UserAccount login(AuthRequestDto request);
}