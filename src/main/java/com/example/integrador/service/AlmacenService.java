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
        
        return data.findById(id);
    }
    @Override
    public int Save(Almacen a) {
        int res=0;
        Almacen almacen=data.save(a);
        if (!almacen.equals(null)) {
            res=1;
        }
        return res;
    }
    @Override
    public void delete(int id) {
        data.deleteById(id);
        
    }

}