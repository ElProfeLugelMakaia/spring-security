package com.example.asistencias.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/asistencias")
public class AsistenciasController {

    @PostMapping()
    public String post(@RequestBody String s){
        return s;
    }

    @PostMapping("prueba")
    public String postPrueba(@RequestBody String s){
        return s;
    }

    @GetMapping()
    public String get(Authentication authentication){
        return "Si " + authentication.getName();
    }

    @GetMapping("/dashboard")
    public String getDashboard(Authentication authentication){
        return "Si " + authentication.getName();
    }

    @GetMapping("/verify")
    public String getVerify(Authentication authentication){
        return "Si " + authentication.getName();
    }
}
