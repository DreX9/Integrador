package com.example.integrador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrador.clases.Almacenes;
import com.example.integrador.services.AlmacenesServices;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenesController {
    @Autowired
    private AlmacenesServices almacenesServices;
    
    @GetMapping
    public ResponseEntity<List<Almacenes>> listarTodos() {
        List<Almacenes> almacenes = almacenesServices.listarTodos();
        return new ResponseEntity<>(almacenes, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Almacenes> guardar(@RequestBody Almacenes almacen) {
        Almacenes nuevoAlmacen = almacenesServices.guardar(almacen);
        return new ResponseEntity<>(nuevoAlmacen, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Almacenes> actualizar(@PathVariable Long id, @RequestBody Almacenes almacen) {
        try {
            almacen.setId(id);
            Almacenes almacenActualizado = almacenesServices.guardar(almacen);
            return new ResponseEntity<>(almacenActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            almacenesServices.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
