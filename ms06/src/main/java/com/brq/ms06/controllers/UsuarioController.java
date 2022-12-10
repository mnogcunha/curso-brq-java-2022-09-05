package com.brq.ms06.controllers;

import java.util.List;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.mappers.UsuarioMapper;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioMapper mapper;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAll() {
		return ResponseEntity.ok().body(this.service.getAll());
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto.toModel()));
	}

	@PatchMapping(value = "{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable String id,
											 @Valid @RequestBody UsuarioDTO dto) {
		return ResponseEntity.ok().body(service.update(id, dto));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<UsuarioDTO> getOne(@PathVariable String id) {
		return ResponseEntity.ok().body(service.getOne(id));
	}

	@GetMapping(value = "find-by-nome/{nome}")
	public ResponseEntity<List<UsuarioDTO>> findByNome(@PathVariable String nome) {
		return ResponseEntity.ok().body(service.findByNome(nome));
	}

	@GetMapping(value = "find-by-nome-contains/{nome}")
	public ResponseEntity<List<UsuarioDTO>> findByNomeContains(@PathVariable String input) {
		return ResponseEntity.ok().body(service.findByNomeContains(input));
	}

	@GetMapping(value = "find-by-email/{email}")
	public ResponseEntity<Page<UsuarioModel>> findByEmail(
			@PathVariable String email,
			@RequestParam (name = "page", defaultValue = "0") int page,
			@RequestParam (name = "limit", defaultValue = "3") int limit,
			@RequestParam (name = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam (name = "direction", defaultValue = "ASC") String direction){

		return ResponseEntity.ok().body(service.findByEmail(email, page, limit, orderBy, direction));
	}
}