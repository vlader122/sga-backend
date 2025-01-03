package com.blumbit.vlader122.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Persona;
import com.blumbit.vlader122.sga.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personasRepository;
    
    public Page<Persona> listarPersonas(Pageable pageable) {
        return personasRepository.findAll(pageable);
    }

    public Persona obtenerById(Long id) {
        return personasRepository.findById(id).orElse(null);
    }

    public Persona guardar(Persona persona) {
        return personasRepository.save(persona);
    }

    public void eliminar(Long id) {
        personasRepository.deleteById(id);
    }

    public Persona actualizar(Persona persona) {
        return personasRepository.save(persona);
    }
}
