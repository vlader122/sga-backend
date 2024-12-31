package com.blumbit.vlader122.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Personas;
import com.blumbit.vlader122.sga.repository.PersonasRepository;

@Service
public class PersonasService {
    @Autowired
    PersonasRepository personasRepository;
    
    public Page<Personas> listarPersonas(Pageable pageable) {
        return personasRepository.findAll(pageable);
    }

    public Personas obtenerById(Long id) {
        return personasRepository.findById(id).orElse(null);
    }

    public Personas guardar(Personas persona) {
        return personasRepository.save(persona);
    }

    public void eliminar(Long id) {
        personasRepository.deleteById(id);
    }

    public Personas actualizar(Personas persona) {
        return personasRepository.save(persona);
    }
}
