package com.example.integrador.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.integrador.modelo.Proveedor;

public interface IproveedorService {
    public List<Proveedor>listar();
    public Optional<Proveedor>listarId(int id);
    public int save(Proveedor c);
    public void delete(int id);
}
