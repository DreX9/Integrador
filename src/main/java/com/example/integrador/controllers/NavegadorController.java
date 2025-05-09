package com.example.integrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class NavegadorController {
    @GetMapping
    public String inicio () {
        return "inicio";
    }

    @GetMapping("/compras")
    public String compras () {
        return "compras";
    }

}
