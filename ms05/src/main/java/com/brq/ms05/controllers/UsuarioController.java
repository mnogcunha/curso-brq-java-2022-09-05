package com.brq.ms05.controllers;

import com.brq.ms05.models.UsuarioModel;
import com.brq.ms05.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "usuarios")
    public List<UsuarioModel> getAll(){
        return this.service.getAll();
    }
}