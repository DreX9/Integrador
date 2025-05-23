package com.example.integrador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.integrador.modelo.Rol;

@Repository
public interface IRol extends CrudRepository<Rol, Integer>{
    
}
