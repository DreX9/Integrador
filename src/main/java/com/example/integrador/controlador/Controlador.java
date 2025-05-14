package com.example.integrador.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.integrador.interfacesService.IalmcenService;
import com.example.integrador.interfacesService.IclasificacionService;
import com.example.integrador.modelo.Almacen;
import com.example.integrador.modelo.Clasificacion;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IalmcenService service;
    @Autowired
    private IclasificacionService clasService;

    // @GetMapping
    // public String inicio () {
    // return "index";
    // }

    // @GetMapping("/compras")
    // public String compras () {
    // return "compras";
    // }

    // @GetMapping("/ventas")
    // public String ventas () {
    // return "ventas";
    // }

    // @GetMapping("/productos")
    // public String productos () {
    // return "productos";
    // }

    @GetMapping("/clasificaciones")
    public String clasificaciones(Model model) {
        List<Clasificacion> clasificaciones = clasService.listar();
        model.addAttribute("clasificaciones", clasificaciones);
        model.addAttribute("clasificacion", new Clasificacion());
        return "clasificaciones";
    }

    @GetMapping("/almacenes")
    public String listar(Model model) {
        List<Almacen> almacenes = service.listar();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("almacen", new Almacen());
        return "almacenes";
    }

    // @GetMapping("/proveedores")
    // public String proveedores () {
    // return "proveedores";
    // }

    // @GetMapping("/clientes")
    // public String clientes () {
    // return "clientes";
    // }

    // @GetMapping("/empleados")
    // public String empleados () {
    // return "empleados";
    // }

    // @GetMapping("/devolucion-compra")
    // public String devolucionCompra () {
    // return "devolucion-compra";
    // }

    // @GetMapping("/devolucion-venta")
    // public String devolucionVenta () {
    // return "devolucion-venta";
    // }

    // @GetMapping("/inventarios")
    // public String inventarios () {
    // return "inventarios";
    // }

    // @GetMapping("/reportes")
    // public String reportes () {
    // return "reportes";
    // }

    @PostMapping("/save")
    public String save(@Valid Almacen a, Model model) {
        service.Save(a);
        return "redirect:/almacenes";
    }

    @PostMapping("/saveClasificacion")
    public String saveClasificacion(@Valid Clasificacion c, Model model) {
        clasService.save(c);
        return "redirect:/clasificaciones";
    }

    @GetMapping("/editarClasificaciones/{id_clasificacion}")
    public String editarClasificaciones(@PathVariable int id_clasificacion, Model model) {
        Optional<Clasificacion> clasificacion = clasService.listarId(id_clasificacion);
        List<Clasificacion> clasificaciones = clasService.listar();
        model.addAttribute("clasificaciones", clasificaciones);        
        model.addAttribute("clasificacion", clasificacion.get());
        return "clasificaciones"; 
    }

    @GetMapping("/editar/{id_almacen}")
    public String editar(@PathVariable int id_almacen, Model model) {
        Optional<Almacen> almacen = service.listarId(id_almacen);
        List<Almacen> almacenes = service.listar();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("almacen", almacen.get());
        return "almacenes";
    }

    @GetMapping("/deleteClasificaciones/{id_clasificacion}")
    public String deleteClasificaciones(@PathVariable int id_clasificacion, Model model) {
        clasService.delete(id_clasificacion);
        return "redirect:/clasificaciones";
    }

    @GetMapping("/eliminar/{id_almacen}")
    public String delete(@PathVariable int id_almacen, Model model) {
        service.delete(id_almacen);
        return "redirect:/almacenes";
    }

}
