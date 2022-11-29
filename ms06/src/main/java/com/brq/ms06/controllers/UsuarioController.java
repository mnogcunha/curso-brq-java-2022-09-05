package com.brq.ms06.controllers;

import java.util.List;

import com.brq.ms06.mappers.UsuarioMapper;
import com.brq.ms06.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brq.ms06.dtos.UsuarioDTO;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	 @Autowired
	 private IUsuarioService service;

	 @Autowired
	 private UsuarioMapper mapper;
	 
	 @GetMapping
	 public ResponseEntity<List<UsuarioDTO>> getAll(){

		 return ResponseEntity.ok().body( this.service.getAll() );
	    }
}