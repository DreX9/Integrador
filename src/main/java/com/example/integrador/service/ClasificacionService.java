package com.example.integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrador.interfaces.IClasificacion;
import com.example.integrador.interfacesService.IclasificacionService;
import com.example.integrador.modelo.Clasificacion;

@Service
public class ClasificacionService implements IclasificacionService{
    @Autowired
    private IClasificacion data;
    
    @Override
    public List<Clasificacion> listar() {
        return (List<Clasificacion>)data.findAll();
    }

    @Override
    public Optional<Clasificacion> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Clasificacion c) {
        int res = 0;
        Clasificacion clasificacion = data.save(c);
        if (!clasificacion.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);   
    }
    
}
