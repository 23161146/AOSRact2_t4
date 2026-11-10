package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vistas")
public class ProductoViewController {

    @Value("${app.autor}")
    private String autor;

    @Value("${app.proyecto}")
    private String proyecto;

    private final List<ProductoDTO> productos = new ArrayList<>(List.of(
        new ProductoDTO(1L, "Laptop", 15000.0, "Tecnologia"),
        new ProductoDTO(2L, "Silla", 1800.0, "Hogar"),
        new ProductoDTO(3L, "Mouse", 250.0, "Tecnologia")
    ));

    @GetMapping("/productos")
    public String listar(@RequestParam(required = false) String categoria, Model model) {
        List<ProductoDTO> resultado = (categoria == null || categoria.isBlank())
            ? productos
            : productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria)).toList();
        model.addAttribute("productos", resultado);
        model.addAttribute("autor", autor);
        model.addAttribute("proyecto", proyecto);
        return "lista";
    }

    @GetMapping("/productos/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        ProductoDTO p = productos.stream()
            .filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("producto", p);
        return "detalle";
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        return "formulario";
    }

    @PostMapping("/formulario")
    public String procesar(@ModelAttribute("producto") ProductoDTO producto, Model model) {
        model.addAttribute("producto", producto);
        return "resultado";
    }
}
