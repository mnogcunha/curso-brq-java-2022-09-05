package com.brq.ms05.services;

import com.brq.ms05.models.UsuarioModel;
import com.brq.ms05.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioModel> getAll() {
        return repository.findAll();
    }
}