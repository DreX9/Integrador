package com.example.integrador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.integrador.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Integer>{
    
}
