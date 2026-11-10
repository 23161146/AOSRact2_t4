package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @PostMapping
    public ProductoDTO crear(@RequestBody ProductoDTO dto) {
        return dto;
    }
}
