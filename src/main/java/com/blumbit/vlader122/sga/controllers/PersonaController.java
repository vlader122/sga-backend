package com.blumbit.vlader122.sga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.vlader122.sga.models.Persona;
import com.blumbit.vlader122.sga.services.PersonaService;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {

    @Autowired
    private PersonaService personasService;

    @GetMapping
    public ResponseEntity<Page<Persona>> listarPersonas(Pageable pageable) {
        Page<Persona> personas = personasService.listarPersonas(pageable);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public Persona obtenerById(@PathVariable Long id) {
        return personasService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
        personasService.guardar(persona);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personasService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Persona> actualizar(@RequestBody Persona persona) {
        personasService.actualizar(persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
