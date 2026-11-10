package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    @GetMapping
    public List<String> listar() {
        return List.of("Programación Web", "Bases de Datos", "Redes");
    }
}