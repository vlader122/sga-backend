package com.blumbit.vlader122.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Asignacion;
import com.blumbit.vlader122.sga.models.DetalleAsignacion;
import com.blumbit.vlader122.sga.repository.AsignacionRepository;
import com.blumbit.vlader122.sga.repository.DetalleAsignacionRepository;

@Service
public class AsignacionService {
    @Autowired
    AsignacionRepository asignacionesRepository;
    @Autowired
    DetalleAsignacionRepository detalleAsignacionRepository;
    
    public Page<Asignacion> listarAsignaciones(Pageable pageable) {
        return asignacionesRepository.findAll(pageable);
    }

    public Asignacion obtenerById(Long id) {
        return asignacionesRepository.findById(id).orElse(null);
    }

    public Asignacion guardar(Asignacion asignacion) {
        Asignacion asignacionGuardada = asignacionesRepository.save(asignacion);
        List<DetalleAsignacion> listaDetalle = asignacion.detalleAsignacion;
        for (DetalleAsignacion detalleAsignacion : listaDetalle) {
            detalleAsignacion.idasignacion = asignacionGuardada.id;
            detalleAsignacionRepository.save(detalleAsignacion);
        }
        return asignacionGuardada;
    }

    public void eliminar(Long id) {
        asignacionesRepository.deleteById(id);
    }

    public Asignacion actualizar(Asignacion asignacion) {
        return asignacionesRepository.save(asignacion);
    }
}
