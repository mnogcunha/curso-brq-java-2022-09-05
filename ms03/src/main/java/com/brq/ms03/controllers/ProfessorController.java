package com.brq.ms03.controllers;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProfessorController {

    // private UsuarioService usuServ = new UsuarioService(); (usado conforme abaixo)
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo ProfessorService
    @Autowired
    private ProfessorService profServ;

    // O @GetMapping permite associoar o verbo GET com a rota /professor
    @GetMapping("professor")
    public List<ProfessorDTO> getAllProfessor() {

        profServ.mostrarMensagemService();
        //   ArrayList<UsuarioModel> usuarios = usuServ.getAllProfessor();
        //   return usuarios;
        return profServ.getAllProfessor();
    }

    // O @PostMapping permite associar o verbo POST com a rota /professor
    @PostMapping("professor")
    public ProfessorDTO create(@Valid @RequestBody ProfessorDTO professor) {
        //   ProfessorModel u = profServ.create(professor)
        return profServ.create(professor);
    }

    // O @PatchMapping permite associar o verbo PATCH com a rota /professor/{id}
    @PatchMapping("professor/{id}")
    public ProfessorDTO update(@RequestBody ProfessorDTO professorBody, @PathVariable int id ) {
        //        ProfessorModel u = profService.update(id, professorBody);
        //        return u;
        return profServ.update(id, professorBody);
    }

    // O @DeleteMapping permite associar o verbo DELETE com a rota /professor/{id}
    @DeleteMapping("professor/{id}")
    public String delete(@PathVariable int id) {
        //String response = profService.delete(id);
        //return response;
        return profServ.delete(id);
    }

    // O @GetMapping permite associoar o verbo GET(getOne) com a rota /usuarios/{id}
    // busca por apenas um professor (pelo id)
    @GetMapping("professor/{id}")
    public ProfessorDTO getOne(@PathVariable int id) {
        //        ProfessorModel u = profService.getOne(id);
        //        return u;
        //
        return profServ.getOne(id);
    }
}
