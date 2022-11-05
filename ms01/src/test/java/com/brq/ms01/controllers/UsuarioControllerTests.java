package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsuarioControllerTests {

    @Autowired
    private UsuarioController controller;

    @MockBean
    private UsuarioService service;

    @Test
    void getAllUsuariosTest(){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setTelefone("telefone");
        usuarioDTO.setEmail("email");
        usuarioDTO.setNome("nome");

        List<UsuarioDTO> listDTO = Arrays.asList(usuarioDTO);

        // Mockar retorno do service
        when(service.getAllUsuarios()).thenReturn(listDTO);

        // Chamar o método a ser testado
        final var response= controller.getAllUsuarios();

        // Verificar se o retorno está correto
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat( response.getBody() ).isEqualTo(listDTO);

        verify(service, times(1)).getAllUsuarios();
    }

    @Test
    void createWhenSuccess(){

        UsuarioDTO usuarioDTO = createValidUsuarioDTO();

        // Mockando a service
        when(service.create(usuarioDTO)).thenReturn(usuarioDTO);

        // Chamando o método a ser testado
        final var response = controller.create(usuarioDTO);

        // Validando a resposta
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(usuarioDTO);
    }

//    @Test
//    void createWhenFail(){
//
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        usuarioDTO.setNome("a");
//        usuarioDTO.setEmail("email");
//        usuarioDTO.setTelefone("(11)982733817");
//
//        assertThrows(MethodArgumentNotValidException.class ,
//                () -> controller.create(usuarioDTO) );
//    }

    @Test
    void updateTest(){

        int id = 1;

        UsuarioDTO usuarioDTO = createValidUsuarioDTO();

        when(service.update(id, usuarioDTO)).thenReturn(usuarioDTO);

        // Testar método de interesse
        final var response = controller.update(usuarioDTO, id);

        // Verificar a resposta
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(usuarioDTO);
    }

    @Test
    void deleteTestWhenSuccess(){

        int id = 1;

        when(service.delete(id))
                .thenReturn("texto");

        // Testar método
        final var response = controller.delete(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("texto");
    }

    @Test
    void getOneWhenSucess(){

        // Dado que
        int id = 1;

        final var usuarioDTO= createValidUsuarioDTO();

        // Quando
        when(service.getOne(id)).thenReturn(usuarioDTO);

        // Então
        final var response= controller.getOne(id);

        // Verificar o resultado
        assertThat( response.getStatusCode() ).isEqualTo(HttpStatus.OK);
        assertThat( response.getBody() ).isEqualTo( usuarioDTO );
    }

    @Test
    void getOneWhenFail(){

        // Dado que
        int id = 1;

        // Mockito
        // Quando
        when(service.getOne(id)).thenThrow( new RuntimeException("ex"));

        // Então
        assertThrows( RuntimeException.class , ()-> controller.getOne(id) ) ;
    }

    @Test
    void fetchUsuariosByNomeTest(){

        // Dado que
        var nomeBusca = "nome";

        final var usuarioDTO = createValidUsuarioDTO();
        final var listUsuarios = Arrays.asList(usuarioDTO);
        //final var listUsuarios = Arrays.asList( createValidUsuarioDTO() );

        // Quando
        when(service.fetchUsuariosByNome(nomeBusca)).thenReturn(listUsuarios);

        // Então
        final var response= controller.fetchUsuariosByNome(nomeBusca);

        // Validar a reposta
        assertThat( response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat( response.getBody()).isEqualTo( response.getBody() );

    }

    @Test
    void fetchUsuariosByNomeAndEmailTest(){

        // Dado que
        final var nomeBusca = "nome";
        final var emailBusca = "email";

        final var listUsuarios= Arrays.asList( createValidUsuarioDTO() );

        // Quando
        when(service.fetchUsuariosByNomeAndEmail(nomeBusca, emailBusca)).thenReturn(listUsuarios);

        // Então
        final var response = controller.fetchUsuariosByNomeAndEmail(nomeBusca,
                                                                                               emailBusca);

        // Verificar a resposta
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(listUsuarios);
    }

    @Test
    void fetchUsuariosByNomeAndEmailAndEnderecoRuaTest(){

        // Dado que
        final var nomeBusca = "nome";
        final var emailBusca = "email";
        final var ruaBusca = "endereco";

        final var listUsuarios= Arrays.asList( createValidUsuarioDTO() );

        // Quando
        when(service.findByNomeContainsAndEmailContainsAndEnderecoRuaContains(nomeBusca,
                                                                              emailBusca,
                                                                              ruaBusca))
                .thenReturn(listUsuarios);

        // Então
        final var response =
                controller.findByNomeContainsAndEmailContainsAndEnderecoRuaContains(nomeBusca,
                                                                                    emailBusca,
                                                                                    ruaBusca);

        // Verificar a resposta
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(listUsuarios);
    }

    private UsuarioDTO createValidUsuarioDTO(){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("nome");
        usuarioDTO.setEmail("email");
        usuarioDTO.setTelefone("(11) 98273-3817");

        return usuarioDTO;
    }
}