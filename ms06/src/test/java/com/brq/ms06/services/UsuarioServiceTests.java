package com.brq.ms06.services;

import com.brq.ms06.exceptions.NaoAcheiException;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsuarioServiceTests {

    // Instanciar o objeto que queremos testar
    @Autowired
    private UsuarioService service;

    // Mockar os outros objetos necessarios para teste unitário
    @MockBean
    private UsuarioRepository repository;

    @Test
    void getAllTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        final var model = UsuarioModel
                .builder()
                .id("1")
                .nome("nome")
                .email("email")
                .build();

        final var listEntity = Arrays.asList(model);
        when(repository.findAll()).thenReturn(listEntity);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        final var response = service.getAll();

        // VERIFICAR (verificar o resultado do passo anterior)
        assertThat(response.get(0).getNome())
                .isEqualTo(listEntity.get(0).getNome());
        assertThat(response.get(0).getEmail())
                .isEqualTo(listEntity.get(0).getEmail());
    }

    @Test
    void getOneWhenFindUserTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String id = "1";
        String nome = "nome";
        String email = "email";
        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var optional = Optional.of(usuarioModel);

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findById(id)).thenReturn(optional);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        final var response = service.getOne(id);

        // VERIFICAR (verificar o resultado do passo anterior)
        assertThat(response.getEmail()).isEqualTo(email);
        assertThat(response.getNome()).isEqualTo(nome);
        assertThat(response.getId()).isEqualTo(id);

    }

    @Test
    void getOneWhenNotFindUserTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        Optional<UsuarioModel> optional = Optional.empty();
        String id = "1";

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findById(id)).thenReturn(optional);

        // ENTÃO (execução do teste: chamar o método a ser testado) e VERIFICAR (verificar o resultado do passo)
        assertThrows( NaoAcheiException.class, () -> service.getOne(id) );
    }


    @Test
    void createTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String nome = "nome";
        String nomeEsperado = "nome";
        String email = "email";
        String emailEsperado = "email";
        String id = "1";
        final var usuarioModelInput = createUsuarioModelMock(id, nome, email);

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        final var usuarioModelExpected = createUsuarioModelMock(id, nomeEsperado, emailEsperado);
        when(repository.save(usuarioModelExpected)).thenReturn(usuarioModelExpected);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        final var response = service.create(usuarioModelInput);

        // VERIFICAR (verificar o resultado do passo anterior)
        assertThat(usuarioModelInput.getId()).isEqualTo(usuarioModelExpected.getId());
        assertThat(usuarioModelInput.getNome()).isEqualTo(nomeEsperado);
        assertThat(usuarioModelInput.getEmail()).isEqualTo(emailEsperado);
    }

    @Test
    void updateWhenFindUserTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String id = "1";
        String nome = "nome";
        String email = "email";
        String nomeExpected = "nome-alterado";
        String emailExpected = "email-alterado";
        final var usuarioModelExpected = createUsuarioModelMock(id, nomeExpected, emailExpected);
        final var usuarioModelInput = createUsuarioModelMock(id, nome, email);

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findById(id)).thenReturn(Optional.of(usuarioModelInput));
        when(repository.save(usuarioModelExpected)).thenReturn(usuarioModelExpected);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        final var response = service.update(id, usuarioModelExpected.toDTO());

        // VERIFICAR (verificar o resultado do passo anterior)
        assertThat(response.getId()).isEqualTo(usuarioModelExpected.getId());
        assertThat(response.getNome()).isEqualTo(usuarioModelExpected.getNome());
        assertThat(response.getEmail()).isEqualTo(usuarioModelExpected.getEmail());
    }

    @Test
    void updateWhenNotFindUserTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String id = "1";
        String nome = "nome";
        String email = "email";

        final var usuarioModelInput = createUsuarioModelMock(id, nome, email);
        Optional<UsuarioModel> usuarioModelOptional = Optional.empty();

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findById(id)).thenReturn(usuarioModelOptional);

        // ENTÃO (execução do teste: chamar o método a ser testado) e VERIFICAR (verificar o resultado do passo)
        final var dto = usuarioModelInput.toDTO();
        assertThrows( NaoAcheiException.class,
                () ->  service.update(id, dto) );
    }

    @Test
    void deleteWhenFindUserTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String id = "1";
        String nome = "nome";
        String email = "email";

        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var optional = Optional.of(usuarioModel);

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findById(id)).thenReturn(optional);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        service.delete(id);

        // VERIFICAR (verificar o resultado do passo anterior)
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void deleteWhenNotFindUserTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        Optional<UsuarioModel> optional = Optional.empty();
        String id = "1";

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findById(id)).thenReturn(optional);

        // ENTÃO (execução do teste: chamar o método a ser testado) e VERIFICAR (verificar o resultado do passo)
        assertThrows( NaoAcheiException.class, () -> service.delete(id) );
    }


    @Test
    void findByNomeTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String nomeInput = "nome-busca";
        String id = "1";
        String nome = "nome";
        String email = "email";
        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var listModel = Arrays.asList(usuarioModel);

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findByNome(nomeInput)).thenReturn(listModel);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        final var response = service.findByNome(nomeInput);

        // VERIFICAR (verificar o resultado do passo anterior)
        assertThat(response.get(0).getId()).isEqualTo(listModel.get(0).getId());
        assertThat(response.get(0).getNome()).isEqualTo(listModel.get(0).getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(listModel.get(0).getEmail());
    }

    @Test
    void findByNomeContainsTest(){

        // DADO QUE (cenário inicial de teste : inicialização das variáveis)
        String nome = "nome";
        String email = "email";
        final var usuarioModel = createUsuarioModelMock(null, nome, email);
        final var listModel = Arrays.asList(usuarioModel);

        // QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
        when(repository.findAll()).thenReturn(listModel);

        // ENTÃO (execução do teste: chamar o método a ser testado)
        final var response = service.findByNomeContains(nome);

        // VERIFICAR (verificar o resultado do passo anterior)
        assertThat(response.get(0).getNome()).isEqualTo(listModel.get(0).getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(listModel.get(0).getEmail());
    }

    @Test
    void findByEmailTest() {
        // Dado que

        final var email = "email";
        final var page = 0;
        final var limit = 5;
        final var direction = Sort.Direction.ASC;
        final var orderBy = "id";
        final var pageRequest =
                PageRequest.of(page, limit, direction, orderBy );


        final var pageUsuarioModel = getPageUsuarioModel();

        // Quando

        when(repository.findByEmail(email, pageRequest))
                .thenReturn(pageUsuarioModel);

        //então

        final var response = service.findByEmail(email, page, limit, orderBy, "ASC");

        // Verificar resultado

        assertThat(response.getContent().size()).isEqualTo(1);
        assertThat(response.getTotalElements()).isEqualTo(1L);

    }

    private Page<UsuarioModel> getPageUsuarioModel(){

        Page<UsuarioModel> pageUsuarioModel = new Page<UsuarioModel>() {

            UsuarioModel model = UsuarioModel
                    .builder()
                    .id("1")
                    .nome("nome")
                    .email("email")
                    .build();

            List<UsuarioModel> listEntity = Arrays.asList(model);

            @Override
            public Iterator<UsuarioModel> iterator() {


                return (Iterator<UsuarioModel>) listEntity;
            }

            @Override
            public Pageable previousPageable() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Pageable nextPageable() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public boolean isLast() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isFirst() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean hasPrevious() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean hasContent() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public Sort getSort() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getSize() {

                return listEntity.size();
            }

            @Override
            public int getNumberOfElements() {

                return listEntity.size();
            }

            @Override
            public int getNumber() {

                return 1;
            }

            @Override
            public List<UsuarioModel> getContent() {

                return listEntity;
            }

            @Override
            public <U> Page<U> map(Function<? super UsuarioModel, ? extends U> converter) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getTotalPages() {

                return 1;
            }

            @Override
            public long getTotalElements() {

                return listEntity.size();
            }
        };

        return pageUsuarioModel;
    }

    private UsuarioModel createUsuarioModelMock(){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNome("nome");
        usuarioModel.setEmail("email");

        return usuarioModel;
    }

    private UsuarioModel createUsuarioModelMock(String id, String nome){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setEmail("email");

        return usuarioModel;
    }

    private UsuarioModel createUsuarioModelMock(String id, String nome, String email){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setEmail(email);

        return usuarioModel;
    }
}