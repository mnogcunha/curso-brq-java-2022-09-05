package com.brq.ms03.services;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository profRepository;

    public void mostrarMensagemService() {
        System.out.println("Mensagem do servico");
    }

    // Uso do verbo GET com a rota /usuarios
    public List<ProfessorDTO> getAllProfessor() {
        // a repository vai executar : SELECT * FROM usuarios;
        List<ProfessorModel> list = profRepository.findAll();

        // Como converter uma lista MODEL para lista DTO?
        List<ProfessorDTO> listDTO = new ArrayList<>();

        // Tipo de variável (carrega ArrayList listaDTO com list (lista UsuarioModel)
        for (ProfessorModel balde : list) {
            listDTO.add(balde.toDTO());
        }
        return listDTO;
    }

    // Uso do verbo POST com a rota /usuarios
    public ProfessorDTO create(ProfessorDTO professor) {

        // Temos que converter um DTO para um MODEL
        // jeito Fabrizio (Burro)
//        UsuarioModel usuarioDTOtoModel = new UsuarioModel();
//        usuarioDTOtoModel.setId( usuario.getId() );
//        usuarioDTOtoModel.setNome(usuario.getNome());
//        usuarioDTOtoModel.setTelefone(usuario.getTelefone());
//        usuarioDTOtoModel.setEmail(usuario.getEmail());

        // INSERT INTO usuarios (name_user, email_user ) VALUEs()....
        ProfessorModel usuarioSalvo = profRepository.save( professor.toModel());
        return usuarioSalvo.toDTO();
    }

    // Uso do verbo PATCH com a rota /usuarios/{id}
    public ProfessorDTO update(int id, ProfessorDTO professorBody) {
        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        professor.setSalario( professorBody.getSalario() );
        professor.setNome( professorBody.getNome() );
        professor.setCpf( professorBody.getCpf() );
        professor.setTelefone( professorBody.getTelefone() );
        return profRepository.save(professor).toDTO();
    }

    // Uso do verbo DELETE com a rota /professor/{id}
    public String delete(int id) {
        profRepository.deleteById(id);
        return "Professor delatado com sucesso!";
    }

    // Uso do verbo GET(getOne) com a rota /professor/{id}
    public ProfessorDTO getOne(int id) {
        ProfessorModel professor = profRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return professor.toDTO();
    }
}