package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    // private UsuarioService usuServ = new UsuarioService(); (usado conforme abaixo)
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo UsuarioService
    @Autowired
    private UsuarioService usuServ;

    // O @GetMapping permite associoar o verbo GET com a rota /usuarios
    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {

        usuServ.mostrarMensagemService();
        //   ArrayList<UsuarioModel> usuarios = usuServ.getAllUsuarios();
        //   return usuarios;
        var usuarios = usuServ.getAllUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    // O @PostMapping permite associar o verbo POST com a rota /usuarios
    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuario) {
        //   UsuarioModel u = usuServ.create(usuario)
        var in = usuServ.create(usuario);
        return ResponseEntity.ok() .body(in);
    }

    // O @PatchMapping permite associar o verbo PATCH com a rota /usuarios/{id}
    @PatchMapping("usuarios/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioBody,
                                             @PathVariable int id ) {
        //        UsuarioModel u = usuService.update(id, usuarioBody);
        //        return u;
        var up = usuServ.update(id, usuarioBody);
        return ResponseEntity.ok().body(up);
    }

    // O @DeleteMapping permite associar o verbo DELETE com a rota /usuarios/{id}
    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        //String response = usuService.delete(id);
        //return response;
        var d = usuServ.delete(id);
        return ResponseEntity.ok().body(d);
    }

    // O @GetMapping permite associoar o verbo GET(getOne) com a rota /usuarios/{id}
    // busca por apenas um usuário (pelo id)
    @GetMapping("usuarios/{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable int id) {
        //        UsuarioModel u = usuService.getOne(id);
        //        return u;
        var resp = usuServ.getOne(id);
        return ResponseEntity.ok().body(resp);
    }

    // usuarios/nome/Fabrizio
    @GetMapping("usuarios/nome/{nomeBusca}")
    public ResponseEntity<List<UsuarioDTO>> fetchUsuariosByNome(@PathVariable String nomeBusca){
        // TODO: Não esquecer do ResponseEntity
        var list = usuServ.fetchUsuariosByNome(nomeBusca);
        return ResponseEntity.ok().body(list);
    }

    // usuarios/nome/Marcelo/email/mno
    @GetMapping("usuarios/nome/{nomeBusca}/email/{emailBusca}")
    public ResponseEntity<List<UsuarioDTO>> fetchUsuariosByNomeAndEmail(@PathVariable String nomeBusca,
                                                                        @PathVariable String emailBusca){
        // TODO: Não esquecer do ResponseEntity
        //return usuServ.fetchUsuariosByNomeAndEmail(nomeBusca, emailBusca);
        var list = usuServ.fetchUsuariosByNomeAndEmail(nomeBusca, emailBusca);
        return ResponseEntity.ok().body(list);
    }

    // usuarios/nome/Marcelo/email/mno
    @GetMapping("usuarios/nome/{nomeBusca}/email/{emailBusca}/rua/{ruaBusca}")
    public ResponseEntity<List<UsuarioDTO>> findByNomeContainsAndEmailContainsAndEnderecoRuaContains(@PathVariable String nomeBusca,
                                                                                                     @PathVariable String emailBusca,
                                                                                                     @PathVariable String ruaBusca){
        // TODO: Não esquecer do ResponseEntity
        //return usuServ.findByNomeContainsAndEmailContainsAndEnderecoRuaContains(nomeBusca, emailBusca, ruaBusca);
        var list = usuServ.findByNomeContainsAndEmailContainsAndEnderecoRuaContains(nomeBusca,
                                                                                                   emailBusca,
                                                                                                   ruaBusca);
        return ResponseEntity.ok().body(list);
    }
}