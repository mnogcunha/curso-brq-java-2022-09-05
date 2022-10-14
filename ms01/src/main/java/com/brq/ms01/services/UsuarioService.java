package com.brq.ms01.services;

import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// A camada Service é responsável por armazenar as regras de negócio da aplicação
@Service
public class UsuarioService {

    // Este ArrayList é didático, pois está simulando um banco de dados
    private ArrayList<UsuarioModel> usuarios = new ArrayList<>();
    private int counter = 1;

    @Autowired
    private UsuarioRepository usuRepository;

    public void mostrarMensagemService() {

        System.out.println("Mensagem do servico");
    }
    // Uso do verbo GET com a rota /usuarios
    public List<UsuarioModel> getAllUsuarios() {

        // a repository vai executar : SELECT * FROM usuarios;
        List<UsuarioModel> list = usuRepository.findAll();
        return list;
    }
    // Uso do verbo POST com a rota /usuarios
    public UsuarioModel create(UsuarioModel usuario) {
        usuario.setId( counter );
        usuarios.add(usuario);
        counter++;
        return usuario;
    }
    // Uso do verbo PATCH com a rota /usuarios/{id}
    public UsuarioModel update(int id, UsuarioModel usuarioBody) {
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

    // Uso do verbo DELETE com a rota /usuarios/{id}
    public String delete(int id) {
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

    // Uso do verbo GET(getOne) com a rota /usuarios/{id}
    public UsuarioModel getOne(int id) {
        // busca por apenas um usuário (pelo id)
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getId() == id){
                return usuarios.get(i);
            } // if
        } // for
        return null;
    }
}