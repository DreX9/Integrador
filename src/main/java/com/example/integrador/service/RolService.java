package com.example.integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrador.interfaces.IRol;
import com.example.integrador.interfacesService.IrolService;
import com.example.integrador.modelo.Rol;

@Service
public class RolService implements IrolService{

    @Autowired
    private IRol data;

    @Override
    public List<Rol> listar() {
        return (List<Rol>)data.findAll();
    }

    @Override
    public Optional<Rol> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Rol c) {
        int res = 0;
        Rol rol = data.save(c);
        if (!rol.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}
