package com.example.integrador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.integrador.modelo.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{
    
}
