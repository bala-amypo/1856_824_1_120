// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.AuthService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class AuthServiceImpl implements AuthService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public AuthServiceImpl(UserRepository userRepository,
//                            PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public User register(User user) {
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         return userRepository.save(user);
//     }

//     @Override
//     public String login(String username, String password) {
//         User user = userRepository.findByUsername(username)
//                 .orElseThrow(() -> new BadRequestException("Invalid username"));

//         if (!passwordEncoder.matches(password, user.getPassword())) {
//             throw new BadRequestException("Invalid password");
//         }

//         return "LOGIN_SUCCESS";
//     }
// }
