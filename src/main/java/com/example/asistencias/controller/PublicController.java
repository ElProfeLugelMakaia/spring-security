package com.example.asistencias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {

    @GetMapping()
    public String publicPath(){
        return "Public";
    }

    @GetMapping("author")
    public String author(){
        return "El profe Lugel Makaia";
    }
}
