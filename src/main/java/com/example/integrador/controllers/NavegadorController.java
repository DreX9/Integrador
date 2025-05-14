package com.example.integrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class NavegadorController {

    @GetMapping
    public String inicio () {
        return "index";
    }

    @GetMapping("/compras")
    public String compras () {
        return "compras";
    }

    @GetMapping("/ventas")
    public String ventas () {
        return "ventas";
    }

    @GetMapping("/productos")
    public String productos () {
        return "productos";
    }

    @GetMapping("/clasificaciones")
    public String clasificaciones () {
        return "clasificaciones";
    }

    @GetMapping("/almacenes")
    public String almacenes () {
        return "almacenes";
    }

    @GetMapping("/proveedores")
    public String proveedores () {
        return "proveedores";
    }

    @GetMapping("/clientes")
    public String clientes () {
        return "clientes";
    }

    @GetMapping("/empleados")
    public String empleados () {
        return "empleados";
    }

    @GetMapping("/devolucion-compra")
    public String devolucionCompra () {
        return "devolucion-compra";
    }

    @GetMapping("/devolucion-venta")
    public String devolucionVenta () {
        return "devolucion-venta";
    }
    
    @GetMapping("/inventarios")
    public String inventarios () {
        return "inventarios";
    }

    @GetMapping("/reportes")
    public String reportes () {
        return "reportes";
    }

}
