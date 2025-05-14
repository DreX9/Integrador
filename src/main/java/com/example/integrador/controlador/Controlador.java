package com.example.integrador.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.integrador.interfacesService.IalmcenService;
import com.example.integrador.interfacesService.IclasificacionService;
import com.example.integrador.modelo.Almacen;
import com.example.integrador.modelo.Clasificacion;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IalmcenService service;
    private IclasificacionService clasService;

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
    public String clasificaciones (Model model) {
        List<Clasificacion>clasificaciones=clasService.listar();
        model.addAttribute("clasificaciones", clasificaciones);
        return "clasificaciones";
    }

    @GetMapping("/almacenes")
    public String listar(Model model) {
        List<Almacen>almacenes=service.listar();
        model.addAttribute("almacenes", almacenes);
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
