package com.brq.ms05.controllers;

import com.brq.ms05.dtos.UsuarioDTO;
import com.brq.ms05.mappers.UsuarioMapper;
import com.brq.ms05.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Anotação do Swagger
@ApiOperation(
        value = "API de Usuários"
)

@RestController
@RequestMapping(value = "${endpointDoDanilo}")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    // Anotação do Swagger
    @ApiOperation(
            value = "retorna todos os usuários",
            notes = "retorna todos os usuários do Mongo"
    )

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto.toModel()));
    }

    @PatchMapping(value = "{id}")
    public ResponseEntity<UsuarioDTO> update(
            @PathVariable String id,
            @Valid @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String id) {
        return ResponseEntity.ok().body(service.getOne(id));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<UsuarioDTO>> findByNome(@PathVariable String nome) {

        // TODO: Não esquecer do ResponseEntity
        return ResponseEntity
                .ok()
                .body(service.findByNome(nome));
    }
    @GetMapping(value = "/find-by-nome/{nome}")
    public ResponseEntity<List<UsuarioDTO>> findByNomeContains(@PathVariable String nome) {

        // TODO: Não esquecer do ResponseEntity
       return ResponseEntity
               .ok()
               .body(service.findByNomeContains(nome));
    }

    @GetMapping(value = "/find-by-nome/{nomeBusca}/by-email/{emailBusca}")
    public ResponseEntity<List<UsuarioDTO>> findByNomeContainsAndEmailContains(@PathVariable String nomeBusca,
                                                                               @PathVariable String emailBusca){
        // TODO: Não esquecer do ResponseEntity
        return ResponseEntity
                .ok()
                .body(service.findByNomeContainsAndEmailContains(nomeBusca, emailBusca));
    }

    @GetMapping(value = "find-by-all-attrs/{input}")
    public ResponseEntity< List<UsuarioDTO> > findByAllAttrs(
            @PathVariable String input){
        return ResponseEntity.ok().body( service.findByAllAttrs(input) );
    }
}