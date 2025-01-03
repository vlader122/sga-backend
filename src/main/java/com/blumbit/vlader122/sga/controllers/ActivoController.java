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

import com.blumbit.vlader122.sga.models.Activo;
import com.blumbit.vlader122.sga.services.ActivoService;

@RestController
@RequestMapping("/api/v1/activos")
public class ActivoController {

    @Autowired
    private ActivoService activosService;

    @GetMapping
    public ResponseEntity<Page<Activo>> listarPersonas(Pageable pageable) {
        Page<Activo> activos = activosService.listarActivos(pageable);
        return ResponseEntity.ok(activos);
    }

    @GetMapping("/{id}")
    public Activo obtenerById(@PathVariable Long id) {
        return activosService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Activo> guardar(@RequestBody Activo activo) {
        activosService.guardar(activo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        activosService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Activo> actualizar(@RequestBody Activo activo) {
        activosService.actualizar(activo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
