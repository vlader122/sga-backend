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

import com.blumbit.vlader122.sga.models.Personas;
import com.blumbit.vlader122.sga.services.PersonasService;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonasController {

    @Autowired
    private PersonasService personasService;

    @GetMapping
    public ResponseEntity<Page<Personas>> listarPersonas(Pageable pageable) {
        Page<Personas> personas = personasService.listarPersonas(pageable);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public Personas obtenerById(@PathVariable Long id) {
        return personasService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Personas> guardar(@RequestBody Personas persona) {
        personasService.guardar(persona);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personasService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Personas> actualizar(@RequestBody Personas persona) {
        personasService.actualizar(persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
