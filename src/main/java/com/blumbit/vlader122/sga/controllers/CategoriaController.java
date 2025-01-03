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

import com.blumbit.vlader122.sga.models.Categoria;
import com.blumbit.vlader122.sga.services.CategoriaService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriasService;

    @GetMapping
    public ResponseEntity<Page<Categoria>> listarPersonas(Pageable pageable) {
        Page<Categoria> categorias = categoriasService.listarCategorias(pageable);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public Categoria obtenerById(@PathVariable Long id) {
        return categoriasService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria) {
        categoriasService.guardar(categoria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriasService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria) {
        categoriasService.actualizar(categoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
