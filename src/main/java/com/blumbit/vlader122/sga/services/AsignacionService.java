package com.blumbit.vlader122.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Asignacion;
import com.blumbit.vlader122.sga.repository.AsignacionRepository;

@Service
public class AsignacionService {
    @Autowired
    AsignacionRepository asignacionesRepository;
    
    public Page<Asignacion> listarAsignaciones(Pageable pageable) {
        return asignacionesRepository.findAll(pageable);
    }

    public Asignacion obtenerById(Long id) {
        return asignacionesRepository.findById(id).orElse(null);
    }

    public Asignacion guardar(Asignacion asignacion) {
        return asignacionesRepository.save(asignacion);
    }

    public void eliminar(Long id) {
        asignacionesRepository.deleteById(id);
    }

    public Asignacion actualizar(Asignacion asignacion) {
        return asignacionesRepository.save(asignacion);
    }
}
