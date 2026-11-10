package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/proyecto")
    public String proyecto() {
        return "Proyecto de AOSR - Actividad 1";
    }

    @GetMapping("/numero")
    public int numero() {
        return 42;
    }
}