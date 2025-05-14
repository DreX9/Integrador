package com.example.integrador.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proveedores")
@NoArgsConstructor
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    private String nombre_proveedor;
    private String contacto;
    private String telefono;
    private String direccion;
    private String ruc;
    private String matricula_embarcacion;	
    private String puerto_origen;
    private String tipo_proveedor;
    public Proveedor(Integer id_proveedor, String nombre_proveedor, String contacto, String telefono, String direccion, String ruc, String matricula_embarcacion, String puerto_origen, String tipo_proveedor) {
        super();
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.contacto = contacto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ruc = ruc;
        this.matricula_embarcacion = matricula_embarcacion;
        this.puerto_origen = puerto_origen;
        this.tipo_proveedor = tipo_proveedor;

    }
}
