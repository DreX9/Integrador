package com.example.integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrador.interfaces.IAlmacen;
import com.example.integrador.interfacesService.IalmcenService;
import com.example.integrador.modelo.Almacen;

@Service
public class AlmacenService implements IalmcenService{
    @Autowired
    private IAlmacen data;
    @Override
    public List<Almacen> listar() {
        return (List<Almacen>)data.findAll();
    }
    @Override
    public Optional<Almacen> listarId(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
    @Override
    public int Save(Almacen a) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

}