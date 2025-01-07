package com.blumbit.vlader122.sga.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleAsignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long idactivo;
    public Long idasignacion;
    public Integer estado;

    @ManyToOne
    @JoinColumn(name = "idactivo", insertable = false, updatable = false)
    private Activo activo;

    @ManyToOne
    @JoinColumn(name = "idasignacion", insertable = false, updatable = false)
    private Asignacion asignacion;

}
