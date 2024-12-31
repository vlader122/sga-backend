package com.blumbit.vlader122.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Categorias;
import com.blumbit.vlader122.sga.repository.CategoriasRepository;

@Service
public class CategoriasService {
    @Autowired
    CategoriasRepository categoriasRepository;
    
    public List<Categorias> listarCategorias() {
        return categoriasRepository.findAll();
    }

    public Categorias obtenerById(Long id) {
        return categoriasRepository.findById(id).orElse(null);
    }

    public Categorias guardar(Categorias categoria) {
        return categoriasRepository.save(categoria);
    }

    public void eliminar(Long id) {
        categoriasRepository.deleteById(id);
    }

    public Categorias actualizar(Categorias categoria) {
        return categoriasRepository.save(categoria);
    }
}
