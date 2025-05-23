package com.example.integrador.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.integrador.modelo.Cliente;

public interface IclienteService {
    public List<Cliente>listar();
    public Optional<Cliente>listarId(int id);
    public int save(Cliente c);
    public void delete(int id);
}
