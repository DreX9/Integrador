package com.example.integrador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.integrador.modelo.Almacen;

@Repository
public interface IAlmacen extends CrudRepository<Almacen, Integer>{

    
}