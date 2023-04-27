package com.example.demojwt.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {
    @GetMapping
    public HttpEntity<?> getOutcomes(){
        return ResponseEntity.ok("here is outcomes");
    }
}
