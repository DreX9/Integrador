package com.example.integrador.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacenes")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_almacen;
    private String nombre;
    private String descripcion;
    private String direccion;
    public Almacen() {

    }
    public Almacen(Integer id_almacen, String nombre, String direccion, String descripcion) {
        super();
        this.id_almacen = id_almacen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Integer getId_almacen() {
        return id_almacen;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setId_almacen(Integer id_almacen) {
        this.id_almacen = id_almacen;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
