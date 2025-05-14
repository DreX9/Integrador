package com.example.integrador.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clasificaciones")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clasificacion;
    private String nombre_clasificacion;
    private String tipo_clasificacion;

    public Clasificacion (){
    }

    public Clasificacion(int id_clasificacion, String nombre_clasificacion, String tipo_clasificacion) {
        this.id_clasificacion = id_clasificacion;
        this.nombre_clasificacion = nombre_clasificacion;
        this.tipo_clasificacion = tipo_clasificacion;
    }

    public int getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public String getNombre_clasificacion() {
        return nombre_clasificacion;
    }

    public void setNombre_clasificacion(String nombre_clasificacion) {
        this.nombre_clasificacion = nombre_clasificacion;
    }

    public String getTipo_clasificacion() {
        return tipo_clasificacion;
    }

    public void setTipo_clasificacion(String tipo_clasificacion) {
        this.tipo_clasificacion = tipo_clasificacion;
    }

    
}
