package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    // private UsuarioService usuServ = new UsuarioService(); (usado conforme abaixo)
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo UsuarioService
    @Autowired
    private UsuarioService usuServ;

    // O @GetMapping permite associoar o verbo GET com a rota /usuarios
    @GetMapping("usuarios")
    public List<UsuarioModel> getAllUsuarios() {

        usuServ.mostrarMensagemService();
        //   ArrayList<UsuarioModel> usuarios = usuServ.getAllUsuarios();
        //   return usuarios;
        return usuServ.getAllUsuarios();
    }

    // O @PostMapping permite associar o verbo POST com a rota /usuarios
    @PostMapping("usuarios")
    public UsuarioDTO create(@RequestBody UsuarioDTO usuario) {
        //   UsuarioModel u = usuServ.create(usuario)
        return usuServ.create(usuario);
    }

    // O @PatchMapping permite associar o verbo PATCH com a rota /usuarios/{id}
    @PatchMapping("usuarios/{id}")
    public UsuarioDTO update(@RequestBody UsuarioDTO usuarioBody, @PathVariable int id ) {
        //        UsuarioModel u = usuService.update(id, usuarioBody);
        //        return u;
        return usuServ.update(id, usuarioBody);
    }

    // O @DeleteMapping permite associar o verbo DELETE com a rota /usuarios/{id}
    @DeleteMapping("usuarios/{id}")
    public String delete(@PathVariable int id) {
        //String response = usuService.delete(id);
        //return response;
        return usuServ.delete(id);
    }

    // O @GetMapping permite associoar o verbo GET(getOne) com a rota /usuarios/{id}
    // busca por apenas um usuário (pelo id)
    @GetMapping("usuarios/{id}")
    public UsuarioModel getOne(@PathVariable int id) {
        //        UsuarioModel u = usuService.getOne(id);
        //        return u;
        //
        return usuServ.getOne(id);
    }
}