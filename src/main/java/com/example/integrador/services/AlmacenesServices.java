package com.example.integrador.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.integrador.clases.Almacenes;

@Service

public interface AlmacenesServices {
    List<Almacenes> listarTodos();
    Almacenes guardar(Almacenes almacen);
    void eliminar(Long id);
}
