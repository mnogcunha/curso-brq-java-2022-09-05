package com.brq.ms06.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
    private UsuarioRepository repository;
	
	public List<UsuarioDTO> getAll(){
		
		final var list = (List<UsuarioModel>) repository.findAll();
		
        return list.stream()
        	   .map( UsuarioModel::toDTO )
        	   .collect(Collectors.toList());
    }

}