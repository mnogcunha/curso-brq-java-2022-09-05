package com.brq.ms01.services;

import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // INSERT INTO usuarios (name_user, email_user ) VALUEs()....
        UsuarioModel usur = usuRepository.save(usuario);
        System.out.println("Criou ID "+usur);
        return usur;
    }

    // Uso do verbo PATCH com a rota /usuarios/{id}
    public UsuarioModel update(int id, UsuarioModel usuarioBody) {
        UsuarioModel usuario = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        usuario.setEmail( usuarioBody.getEmail() );
        usuario.setNome( usuarioBody.getNome() );
        return usuRepository.save(usuario);

//        // Ver se o id existe no banco de dados
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//        if(usuarioOptional.isPresent()) {
//            // Eu achei o usuário no banco de dados
//            UsuarioModel meuUsuario = usuarioOptional.get();
//            meuUsuario.setNome( usuarioBody.getNome() );
//            meuUsuario.setEmail( usuarioBody.getEmail() );
//            UsuarioModel usuarioSalvo = usuRepository.save(meuUsuario);
//            return usuarioSalvo;
//        }
//        // Não achei o usuário no banco
//        else {
//            return usuarioOptional.orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
//        }
    }

    // Uso do verbo DELETE com a rota /usuarios/{id}
    public String delete(int id) {
        usuRepository.deleteById(id);
        return "Usuário delatado com sucesso!";
    }

    // Uso do verbo GET(getOne) com a rota /usuarios/{id}
    public UsuarioModel getOne(int id) {
        return usuRepository.findById(id).orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
//        // Ver se o id existe no banco de dados
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//        if(usuarioOptional.isPresent()) {
//            // Eu achei o usuário no banco de dados
//            UsuarioModel meuUsuario = usuarioOptional.get();
//            return meuUsuario;
//        }
//        // Não achei o usuário no banco
//        else {
//            return usuarioOptional.orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
//        }
    }
}