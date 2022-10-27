package com.brq.ms01.services;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// A camada Service é responsável por armazenar as regras de negócio da aplicação
@Slf4j
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
    public List<UsuarioDTO> getAllUsuarios() {
        // a repository vai executar : SELECT * FROM usuarios;
        List<UsuarioModel> list = usuRepository.findAll();

        // Como converter uma lista MODEL para lista DTO?
        List<UsuarioDTO> listDTO = new ArrayList<>();

        // Tipo de variável (carrega ArrayList listaDTO com list (lista UsuarioModel)
        for (UsuarioModel balde : list) {
            listDTO.add(balde.toDTO());
        }
        return listDTO;
    }

    // Uso do verbo POST com a rota /usuarios
    public UsuarioDTO create(UsuarioDTO usuario) {

        // Temos que converter um DTO para um MODEL
        // jeito Fabrizio (Burro)
//        UsuarioModel usuarioDTOtoModel = new UsuarioModel();
//        usuarioDTOtoModel.setId( usuario.getId() );
//        usuarioDTOtoModel.setNome(usuario.getNome());
//        usuarioDTOtoModel.setTelefone(usuario.getTelefone());
//        usuarioDTOtoModel.setEmail(usuario.getEmail());

        UsuarioModel usuarioSalvo = null;

        try{
            // INSERT INTO usuarios (name_user, email_user ) VALUEs()....
            usuarioSalvo = usuRepository.save( usuario.toModel() );
            // return  usuRepository.save( usuario );
            // return "POST Usuários";
            //return usuario;
            log.info(usuarioSalvo.toString());
        }
        catch (Exception exception){
            log.error("Erro ao salvar o usuário: " + exception.getMessage());
        }
        return usuarioSalvo.toDTO();

        // INSERT INTO usuarios (name_user, email_user ) VALUEs()....
        //UsuarioModel usuarioSalvo = usuRepository.save( usuario.toModel());
        //return usuarioSalvo.toDTO();
    }

    // Uso do verbo PATCH com a rota /usuarios/{id}
    public UsuarioDTO update(int id, UsuarioDTO usuarioBody) {
        UsuarioModel usuario = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        usuario.setEmail( usuarioBody.getEmail() );
        usuario.setNome( usuarioBody.getNome() );
        usuario.setTelefone( usuarioBody.getTelefone() );
        return usuRepository.save(usuario).toDTO();

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
    public UsuarioDTO getOne(int id) {
        UsuarioModel usuario = usuRepository.findById(id).orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
        return usuario.toDTO();
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