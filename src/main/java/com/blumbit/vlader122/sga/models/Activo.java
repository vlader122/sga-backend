package com.blumbit.vlader122.sga.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Activo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String codigoInventario;
    public String nombre;
    public Long idcategoria;
    public String marca;
    public String modelo;
    public String serie;
    public String descripcion;
    public boolean estadoAsignacion;

    @ManyToOne
    @JoinColumn(name = "idcategoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }
}