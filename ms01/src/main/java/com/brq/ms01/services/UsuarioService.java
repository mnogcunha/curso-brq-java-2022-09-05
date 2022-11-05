package com.brq.ms01.services;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.exceptions.DataCreateException;
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
public class UsuarioService  implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuRepository;

    public void mostrarMensagemService(){
        //System.out.println("Mensagem do serviço");
        log.info("Mensagem do serviço");
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
    public List<UsuarioDTO> getAllUsuarios2(){

        List<UsuarioModel> list = usuRepository.findAll();

        List<UsuarioDTO> listDTO = new ArrayList<>();

        for (UsuarioModel balde : list) {
            balde.setId( 2 * balde.getId() );
            balde.setNome( balde.getNome() + "JAVA" );
            listDTO.add( balde.toDTO() );
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
            log.info(usuarioSalvo.toString());
            return usuarioSalvo.toDTO();
        }
        catch (Exception exception){
            log.error("Erro ao salvar o usuario: " + exception.getMessage());
            //hrow new RuntimeException("Erro ao salvar no banco de dados");
            throw new DataCreateException("Erro ao salvar usuário");
        }
    }

    // Uso do verbo PATCH com a rota /usuarios/{id}
    public UsuarioDTO update(int id, UsuarioDTO usuarioBody) {

        // TODO: Fazer uma exceção para quando não encontrar o dado, Sugestão: ObjNotFountException. Retornar status 404
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

        final var usuario = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        log.info("deletando usuário id: {} com sucesso, email : {}",
                usuario.getId(), usuario.getEmail() );

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

    public List<UsuarioDTO> fetchUsuariosByNome(String nomeBusca){

        // Pesquisa pelo findby
        //List<UsuarioModel> list = usuRepository.findByNome(nomeBusca);
        //List<UsuarioModel> list = usuRepository.findByNomeContains(nomeBusca);

        // Usando JPQL
        //List<UsuarioModel> list = usuRepository.fetchByNomeLike(nomeBusca);
        List<UsuarioModel> list = usuRepository.fetchByNomeLikeNativeQuery(nomeBusca);

        List<UsuarioDTO> listDTO = new ArrayList<>();

        // Tipo da variável -
        for (UsuarioModel balde : list) {
            listDTO.add( balde.toDTO() );
        }
        return listDTO;
    }

    public List<UsuarioDTO> fetchUsuariosByNomeAndEmail(String nomeBusca, String emailBusca) {

        //List<UsuarioModel> list = usuRepository.findByNomeAndEmail(nomeBusca, emailBusca);
        List<UsuarioModel> list = usuRepository.findByNomeContainsAndEmailContains(nomeBusca, emailBusca);

        List<UsuarioDTO> listDTO = new ArrayList<>();

        // Tipo da variável -
        for (UsuarioModel balde : list) {
            listDTO.add(balde.toDTO());
        }
        return listDTO;
    }

        public List<UsuarioDTO> findByNomeContainsAndEmailContainsAndEnderecoRuaContains(String nomeBusca,
                                                                                         String emailBusca,
                                                                                         String ruaBusca){

            //List<UsuarioModel> list = usuRepository.findByNome(nomeBusca);
            List<UsuarioModel> list =
                    usuRepository.findByNomeContainsAndEmailContainsAndEnderecoRuaContains(nomeBusca,
                                                                                           emailBusca,
                                                                                           ruaBusca);

            List<UsuarioDTO> listDTO = new ArrayList<>();

            // Tipo da variável -
            for (UsuarioModel balde : list) {
                listDTO.add( balde.toDTO() );
            }

            return listDTO;
    }
}