package com.example.integrador.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.integrador.modelo.Usuario;

public interface IusuarioService {
    public List<Usuario>listar();
    public Optional<Usuario>listarId(int id);
    public int save(Usuario u);
    public void delete(int id);
}
