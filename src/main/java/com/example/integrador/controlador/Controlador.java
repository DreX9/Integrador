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
<<<<<<< HEAD
import com.example.integrador.modelo.Clasificacion;

import jakarta.validation.Valid;
=======

import com.example.integrador.modelo.Clasificacion;

import jakarta.validation.Valid;


>>>>>>> 54a208487f3d8f0b0b045ffbbfbc98e2ddd7a6e1

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IalmcenService service;
    @Autowired
    private IclasificacionService clasService;

    // @GetMapping
    // public String inicio () {
    //     return "index";
    // }

    // @GetMapping("/compras")
    // public String compras () {
    //     return "compras";
    // }

    // @GetMapping("/ventas")
    // public String ventas () {
    //     return "ventas";
    // }

    // @GetMapping("/productos")
    // public String productos () {
    //     return "productos";
    // }

    @GetMapping("/clasificaciones")
    public String clasificaciones (Model model) {
        List<Clasificacion>clasificaciones=clasService.listar();
        model.addAttribute("clasificaciones", clasificaciones);
        model.addAttribute("clasificacion", new Clasificacion());
        return "clasificaciones";
    }

    @GetMapping("/almacenes")
    public String listar(Model model) {
        List<Almacen>almacenes=service.listar();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("almacen", new Almacen());
        return "almacenes";
    }

<<<<<<< HEAD
    // @GetMapping("/proveedores")
    // public String proveedores () {
    //     return "proveedores";
    // }

    // @GetMapping("/clientes")
    // public String clientes () {
    //     return "clientes";
    // }

    // @GetMapping("/empleados")
    // public String empleados () {
    //     return "empleados";
    // }

    // @GetMapping("/devolucion-compra")
    // public String devolucionCompra () {
    //     return "devolucion-compra";
    // }

=======

    // @GetMapping("/proveedores")
    // public String proveedores () {
    //     return "proveedores";
    // }

    // @GetMapping("/clientes")
    // public String clientes () {
    //     return "clientes";
    // }

    // @GetMapping("/empleados")
    // public String empleados () {
    //     return "empleados";
    // }

    // @GetMapping("/devolucion-compra")
    // public String devolucionCompra () {
    //     return "devolucion-compra";
    // }

>>>>>>> 54a208487f3d8f0b0b045ffbbfbc98e2ddd7a6e1
    // @GetMapping("/devolucion-venta")
    // public String devolucionVenta () {
    //     return "devolucion-venta";
    // }
    
    // @GetMapping("/inventarios")
    // public String inventarios () {
    //     return "inventarios";
    // }

    // @GetMapping("/reportes")
    // public String reportes () {
    //     return "reportes";
    // }
<<<<<<< HEAD
    
=======
>>>>>>> 54a208487f3d8f0b0b045ffbbfbc98e2ddd7a6e1
    @PostMapping("/save") 
    public String save(@Valid  Almacen a, Model model) {
        service.Save(a);
        return "redirect:/almacenes";
    }
<<<<<<< HEAD

    @PostMapping("/saveClasificacion")
    public String saveClasificacion(@Valid Clasificacion c, Model model) {
        clasService.save(c);
        return "redirect:/clasificaciones";
    }

    @GetMapping("/clasificaciones/editar/{id}")
    public String editar (@PathVariable int id, Model model) {
        Optional<Clasificacion>clasificacion = clasService.listarId(id);
        if (clasificacion.isPresent()) {
        model.addAttribute("clasificacion", clasificacion.get());
    } else {
        return "redirect:/clasificaciones";
    }

    // Siempre cargamos la lista también
     List<Clasificacion>clasificaciones=clasService.listar();
    model.addAttribute("clasificaciones", clasificaciones);

    return "clasificaciones"; // reutiliza misma vista
=======
    @GetMapping("/editar/{id_almacen}")
    public String editar(@PathVariable int id_almacen, Model model){
        Optional<Almacen>almacen=service.listarId(id_almacen);
        List<Almacen> almacenes = service.listar(); 
    model.addAttribute("almacenes", almacenes); 
        model.addAttribute("almacen", almacen.get());
        return "almacenes";
    }

    @GetMapping("/eliminar/{id_almacen}")
    public String delete(@PathVariable int id_almacen, Model model){
        service.delete(id_almacen);
       return "redirect:/almacenes"; 
>>>>>>> 54a208487f3d8f0b0b045ffbbfbc98e2ddd7a6e1
    }
}
