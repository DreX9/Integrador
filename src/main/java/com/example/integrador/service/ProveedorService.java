package com.example.integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrador.interfaces.IProveedor;
import com.example.integrador.interfacesService.IproveedorService;
import com.example.integrador.modelo.Proveedor;

@Service
public class ProveedorService implements IproveedorService {
    @Autowired
    private IProveedor data;
    @Override
    public List<Proveedor> listar() {
        return (List<Proveedor>)data.findAll();
    }
    @Override
    public Optional<Proveedor> listarId(int id) {
        return data.findById(id);
    }
    @Override
    public int saveProveedor(Proveedor c) {
        int res = 0;
        Proveedor proveedor = data.save(c);
        if (!proveedor.equals(null)) {
            res = 1;
        }
        return res;
    }
    @Override
    public void deleteProveedor(int id) {
        data.deleteById(id);   
    }
}
