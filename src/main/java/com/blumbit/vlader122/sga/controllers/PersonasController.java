package com.blumbit.vlader122.sga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.vlader122.sga.models.Personas;
import com.blumbit.vlader122.sga.repository.PersonasRepository;

@RestController
@RequestMapping("/personas")
public class PersonasController {

    @Autowired
    private PersonasRepository personasRepository;

    @GetMapping
    public List<Personas> listarPersonas() {

        return personasRepository.findAll();
    }
}
