package com.blumbit.vlader122.sga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.blumbit.vlader122.sga.models.Categorias;
import com.blumbit.vlader122.sga.services.CategoriasService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public List<Categorias> listarCategorias() {

        return categoriasService.listarCategorias();
    }

    @GetMapping("/{id}")
    public Categorias obtenerById(@PathVariable Long id) {
        return categoriasService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Categorias> guardar(@RequestBody Categorias categoria) {
        categoriasService.guardar(categoria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriasService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Categorias> actualizar(@RequestBody Categorias categoria) {
        categoriasService.actualizar(categoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
