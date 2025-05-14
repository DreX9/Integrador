package com.example.integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.integrador.interfaces.IClasificacion;
import com.example.integrador.interfacesService.IclasificacionService;
import com.example.integrador.modelo.Clasificacion;

public class ClasificacionService implements IclasificacionService{

    @Autowired
    private IClasificacion data;
    @Override
    public List<Clasificacion> listar() {
        return (List<Clasificacion>)data.findAll();
    }

    @Override
    public Optional<Clasificacion> listarId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public int save(Clasificacion c) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
