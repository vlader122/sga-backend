package com.blumbit.vlader122.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Personas;
import com.blumbit.vlader122.sga.repository.PersonasRepository;

@Service
public class PersonasService {
    @Autowired
    PersonasRepository personasRepository;
    
    public List<Personas> listarPersonas() {
        return personasRepository.findAll();
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

    public Personas actualizar(Personas persona, long id) {
        Personas personaActualizada = personasRepository.findById(id).orElse(null);
        personaActualizada.nombre = persona.nombre;
        personaActualizada.apellido = persona.apellido;
        personaActualizada.email = persona.email;
        personaActualizada.telefono = persona.telefono;
        return personasRepository.save(personaActualizada);
    }
}
