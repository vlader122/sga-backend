package com.blumbit.vlader122.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blumbit.vlader122.sga.models.Categoria;
import com.blumbit.vlader122.sga.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriasRepository;
    
    public Page<Categoria> listarCategorias(Pageable pageable) {
        return categoriasRepository.findAll(pageable);
    }

    public Categoria obtenerById(Long id) {
        return categoriasRepository.findById(id).orElse(null);
    }

    public Categoria guardar(Categoria categoria) {
        return categoriasRepository.save(categoria);
    }

    public void eliminar(Long id) {
        categoriasRepository.deleteById(id);
    }

    public Categoria actualizar(Categoria categoria) {
        return categoriasRepository.save(categoria);
    }
}
