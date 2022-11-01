package com.brq.ms01.services;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/*
 * @SpringBootTest: fornece um jeito de iniciar o Spring Boot
 * para utilizar os testes unitários
 * */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioServiceTests {

    // Primeiro temos que instanciar a classe de desejo do teste
    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void getAllUsuariosTest(){
        // O primeiro passo é simular (mockar) os objetos que preciso
        List<UsuarioModel> listMock = new ArrayList<>();

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(1);
        usuarioModel.setNome("Teste");
        usuarioModel.setTelefone("Meu telefone");

        listMock.add(usuarioModel);

        // Quando o findAll da camada repository for acionado, retorno a lista acima
        when ( usuarioRepository.findAll() )
                .thenReturn( listMock );

        // Executar o método de desejo de teste
        List<UsuarioDTO> resultadoAtual = usuarioService.getAllUsuarios();

        //List<UsuarioDTO> resultadoEsperado = new ArrayList<>();

        assertThat(resultadoAtual.get(0).getNome() )
                .isEqualTo("Teste");
        assertThat(resultadoAtual.get(0).getTelefone())
                .isEqualTo("Meu telefone");
        assertThat(resultadoAtual.get(0).getId())
                .isEqualTo(1);
    }

    @Test
    void getAllUsuarios2Test(){

        // o primeiro passo é simular (mockar) os objetos que preciso
        List<UsuarioModel> listMock = new ArrayList<>();

        String nome = "Teste";
        int id = 1;

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setTelefone("Meu telefone");

        listMock.add(usuarioModel);

        // quando o findAll da camada repository for acionado, retorno a lista acima
        when ( usuarioRepository.findAll() )
                .thenReturn( listMock );

        // executar o método de desejo de teste
        List<UsuarioDTO> resultadoAtual = usuarioService.getAllUsuarios2();

        assertThat(resultadoAtual.get(0).getNome() )
                .isEqualTo(nome + "JAVA");
        assertThat(resultadoAtual.get(0).getTelefone())
                .isEqualTo(usuarioModel.getTelefone());
        assertThat(resultadoAtual.get(0).getId())
                .isEqualTo(id * 2);
    }

    @Test
    void createWhenSuccess(){

        String email = "email";
        String nome = "nome";

        // usuário para mockar a repository
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(email);
        dto.setNome(nome);

        UsuarioModel model = dto.toModel();
        model.setId(1);

        when(usuarioRepository.save(dto.toModel())).thenReturn(model);

        // chamar o método a ser testado
        UsuarioDTO salvoDTO = usuarioService.create(dto);

        //verificar se está correto
        assertThat(salvoDTO.getNome()).isEqualTo(nome);
        assertThat(salvoDTO.getEmail()).isEqualTo(email);
        assertThat(salvoDTO.getId()).isGreaterThan(0);
    }

    @Test
    void createWhenFail(){

        // mockar o uso da chave
        when(usuarioRepository.save( null )).thenThrow( new DataIntegrityViolationException("") );

        // testar o método em questão
        assertThrows( RuntimeException.class, () -> usuarioService.create(null)  );
    }
}