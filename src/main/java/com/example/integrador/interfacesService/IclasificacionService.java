package com.example.integrador.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.integrador.modelo.Clasificacion;

public interface IclasificacionService {
    public List<Clasificacion>listar();
    public Optional<Clasificacion>listarId(int id);
    public int save (Clasificacion c);
    public void delete(int id);
}
