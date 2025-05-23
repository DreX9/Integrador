package com.example.integrador.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.integrador.modelo.Proveedor;

@Repository
public interface IProveedor extends CrudRepository<Proveedor, Integer>{
    
}
