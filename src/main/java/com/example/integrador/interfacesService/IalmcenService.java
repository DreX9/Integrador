package com.example.integrador.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.integrador.modelo.Almacen;

public interface IalmcenService {
    public List<Almacen>listar();
    public Optional<Almacen>listarId(int id);
    public int Save(Almacen a);
    public void delete(int id);
}