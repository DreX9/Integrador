package com.example.integrador.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrador.clases.Almacenes;
import com.example.integrador.repository.AlmacenesRepository;
import com.example.integrador.services.AlmacenesServices;

@Service
public class AlmacenesServicesImpl implements AlmacenesServices {
    @Autowired
    private AlmacenesRepository almacenesRepository;

    @Override
    public List<Almacenes> listarTodos() {
        return almacenesRepository.findAll();
    }

    @Override
    public Almacenes guardar(Almacenes almacen) {
        return almacenesRepository.save(almacen);
    }

    @Override
    public void eliminar(Long id) {
        almacenesRepository.deleteById(id);
    }
}
