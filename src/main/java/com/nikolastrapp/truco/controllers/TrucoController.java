package com.nikolastrapp.truco.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrucoController {

    @GetMapping("/oi")
    public String oi(){
        return "Oi";
    }
}
