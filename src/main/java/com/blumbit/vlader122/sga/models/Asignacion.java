package com.blumbit.vlader122.sga.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Date fechaAsignacion;
    public Long idusuario;
    public Long idpersona;
    public String observacion;

    @ManyToOne
    @JoinColumn(name = "idusuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idpersona", insertable = false, updatable = false)
    private Persona persona;

    @OneToMany(mappedBy = "asignacion")
    private List<DetalleAsignacion> detalleAsignacion;

    public List<DetalleAsignacion> getDetalleAsignacion() {
        return detalleAsignacion;
    }
}
