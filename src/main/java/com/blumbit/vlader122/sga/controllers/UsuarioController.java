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

import com.blumbit.vlader122.sga.models.Usuario;
import com.blumbit.vlader122.sga.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuariosService;

    @GetMapping
    public ResponseEntity<Page<Usuario>> listarPersonas(Pageable pageable) {
        Page<Usuario> usuarios = usuariosService.listarUsuarios(pageable);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public Usuario obtenerById(@PathVariable Long id) {
        return usuariosService.obtenerById(id);
    }

    @PostMapping
    ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        usuariosService.guardar(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuariosService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuario) {
        usuariosService.actualizar(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
