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

import com.blumbit.vlader122.sga.models.Asignacion;
import com.blumbit.vlader122.sga.services.AsignacionService;

@RestController
@RequestMapping("/api/v1/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionesService;

    @GetMapping
    public ResponseEntity<Page<Asignacion>> listarPersonas(Pageable pageable) {
        Page<Asignacion> asignaciones = asignacionesService.listarAsignaciones(pageable);
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/{id}")
    public Asignacion obtenerById(@PathVariable Long id) {
        return asignacionesService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Asignacion> guardar(@RequestBody Asignacion asignacion) {
        asignacionesService.guardar(asignacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asignacionesService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Asignacion> actualizar(@RequestBody Asignacion asignacion) {
        asignacionesService.actualizar(asignacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
