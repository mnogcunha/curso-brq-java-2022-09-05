package com.brq.ms07.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ms07.models.CadastroModel;
import com.brq.ms07.repositories.CadastroRepository;

@Service
public class CadastroService implements ICadastroService{

    @Autowired
    private CadastroRepository repository;

    public CadastroModel create(CadastroModel model) {
        return repository.save(model);
    }
}