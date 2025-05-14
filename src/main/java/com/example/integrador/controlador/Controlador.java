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
import com.example.integrador.modelo.Almacen;
import jakarta.validation.Valid;


@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IalmcenService service;

    @GetMapping("/almacenes")
    public String listar(Model model) {
        List<Almacen>almacenes=service.listar();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("almacen", new Almacen());
        return "almacenes";
    }
    @PostMapping("/save") 
    public String save(@Valid  Almacen a, Model model) {
        service.Save(a);
        return "redirect:/almacenes";
    }
    @GetMapping("/editar/{id_almacen}")
    public String editar(@PathVariable int id_almacen, Model model){
        Optional<Almacen>almacen=service.listarId(id_almacen);
        List<Almacen> almacenes = service.listar(); 
    model.addAttribute("almacenes", almacenes); 
        model.addAttribute("almacen", almacen.get());
        return "almacenes";
    }
}
