package com.blumbit.vlader122.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Activo;
import com.blumbit.vlader122.sga.repository.ActivoRepository;

@Service
public class ActivoService {
    @Autowired
    ActivoRepository activosRepository;
    
    public Page<Activo> listarActivos(Pageable pageable) {
        return activosRepository.findAll(pageable);
    }

    public Activo obtenerById(Long id) {
        return activosRepository.findById(id).orElse(null);
    }

    public Activo guardar(Activo activo) {
        return activosRepository.save(activo);
    }

    public void eliminar(Long id) {
        activosRepository.deleteById(id);
    }

    public Activo actualizar(Activo activo) {
        return activosRepository.save(activo);
    }
}
