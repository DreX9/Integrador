package com.example.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.integrador.clases.Almacenes;

public interface AlmacenesRepository extends JpaRepository <Almacenes, Long>{
    
}
