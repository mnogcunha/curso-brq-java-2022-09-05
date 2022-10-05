package com.brq.ms01.controllers;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;

@RestController
public class UsuarioController {

    // Este ArrayList é didático, pois está simulando um banco de dados
    private ArrayList<UsuarioModel> usuarios = new ArrayList<>();
    private int counter = 1;

    /*
     * o @GetMapping permite associoar o verbo GET com a rota /usuarios
     * */
    @GetMapping("usuarios")
    public ArrayList<UsuarioModel> getAllUsuarios() {

//        UsuarioModel u = new UsuarioModel();
//        u.setId(1);
//        u.setNome("Manoel");
//        u.setEmail("manoel@gmail.com");
//
//        usuarios.add(u);

        return usuarios;
    }


    // o PostMapping permite associar o verbo POST com a rota /usuarios
    @PostMapping("usuarios")
    public UsuarioModel create(@RequestBody UsuarioModel usuario) {
        usuario.setId( counter );
        usuarios.add(usuario);
        counter++;
        System.out.println(usuario);
        return usuario;
    }
}