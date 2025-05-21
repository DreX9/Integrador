package com.example.integrador.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.integrador.modelo.Rol;

public interface IrolService {
    public List<Rol>listar();
    public Optional<Rol>listarId(int id);
    public int save(Rol c);
    public void delete(int id);
}
