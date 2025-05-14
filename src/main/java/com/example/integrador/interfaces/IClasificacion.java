package com.example.integrador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.integrador.modelo.Clasificacion;

@Repository
public interface IClasificacion extends CrudRepository<Clasificacion, Integer>{
    
}
