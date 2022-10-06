package com.brq.ms01.controllers;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.web.bind.annotation.*;

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
    @PatchMapping("usuarios/{id}")
    public UsuarioModel update(@RequestBody UsuarioModel usuarioBody,
                               @PathVariable int id ){
        // como achar o usuario a ser alterado?
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                // achamos o usuario a ser alterado
                usuarios.get(i).setNome(usuarioBody.getNome());
                usuarios.get(i).setEmail(usuarioBody.getEmail());
                return usuarios.get(i);
            }
        }
        return null;
    }
    @DeleteMapping("usuarios/{id}")
    public String delete(@PathVariable int id) {

        // como achar o usuario a ser deletado?
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                // achamos o usuario a ser deletado
                usuarios.remove(i);
                return "Usuario deletado com sucesso!";
            }
        }
        return "Usuario não encontrado";
    }
    // busca por apenas um usuário (pelo id)
    @GetMapping("usuarios/{id}")
    public UsuarioModel getOne(@PathVariable int id){

        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getId() == id){
                return usuarios.get(i);
            } // if
        } // for
        return null;
    }
}