package com.example.asistencias.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/verify")
public class VerifyController {

    @GetMapping()
    public String get(Authentication authentication){
        return "Si " + authentication.getName();
    }
}
