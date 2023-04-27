package com.example.demojwt.controller;

import com.example.demojwt.entity.UserLogin;
import com.example.demojwt.config.security.jwt.JwtProvider;
import com.example.demojwt.config.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/login")
public class AuthController {
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping
    public HttpEntity<?> getToken(@RequestBody UserLogin userLogin) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userLogin.getUsername(),
                    userLogin.getPassword()));
            String token = jwtProvider.generateToken(userLogin.getUsername());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("username or password is incorrect");
        }
    }
}
