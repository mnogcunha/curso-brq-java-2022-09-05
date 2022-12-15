package com.brq.ms05.repositories;

import com.brq.ms05.models.UsuarioModel;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
// @DataJpaTest
@ExtendWith(SpringExtension.class)
public class UsuarioRepositoryTests {

    // camade repository de teste
    @Autowired
    private UsuarioRepository repository;

    // permite manipular o banco de dados "embutido" para testes unitários
    @Autowired
    private MongoTemplate mongoTemplate;
//    @Autowired
//    private TestEntityManager testEntityManager;

    // roda o método antes de uma sequência de testes unitários (somente no início)
    @Before
    void runBefore(){

    }
    // roda o método antes de qualquer teste unitário
    @BeforeEach
    void runBeforeEach(){
        mongoTemplate.dropCollection(UsuarioModel.class);
        mongoTemplate.createCollection(UsuarioModel.class);
    }

    @Test
    void findByIdWhenFindUser(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando (inserir dado no banco "embutido")
        final var usuarioInserted = mongoTemplate.insert(usuarioModel);
        // testEntityManager.persist(usuarioModel)

        // então
        final var response = repository
                .findById(usuarioInserted.getId());

        // validar o teste
        assertTrue( response.isPresent() );
    }

    @Test
    void findByIdWhenNotFindUser(){

        // dado que
        final var id = "1";

        // quando

        // então
        final var response = repository.findById(id);

        // validar teste
        assertTrue( response.isEmpty() );
    }

    @Test
    void findAllTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando (inserir dado no banco "embutido")
        mongoTemplate.insert(usuarioModel);
        // testEntityManager.persist(usuarioModel)

        //então (executar o método de interesse do teste)
        final var response = repository.findAll();

        // validar
        //assertThat(response.size()).isGreaterThan(0);
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void saveTest(){
        //dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        //quando

        //então
        final var response = repository.save(usuarioModel);

        //validar teste
        assertThat(response.getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.getEmail()).isEqualTo(usuarioModel.getEmail());
        assertNotNull(response.getId());
    }

    @Test
    void deleteByIdWhenFindUser(){
        // dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        repository.deleteById(userSaved.getId());

        //validar teste
        final var user = repository.findById(userSaved.getId());
        assertTrue(user.isEmpty());
    }

    @Test
    void deleteByIdWhenNotFindUser(){
        // dado que
        String id = null;

        // quando

        // então
        assertThrows( IllegalArgumentException.class,
                ()-> repository.deleteById(id)) ;
    }

    @Test
    void findByNomeTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNome(nome);

        // validar
        //assertThat(response.size()).isGreaterThan(0);
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByNomeNotFoundTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "uma-palavra";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNome(busca);

        // validar
        //assertThat(response.size()).isGreaterThan(0);
        assertTrue(response.isEmpty());
    }

    @Test
    void findByNomeContainsTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeContains(nome);

        // validar
        //assertThat(response.size()).isGreaterThan(0);
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByNomeContainsNotFoundTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "uma-palavra";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeContains(busca);

        // validar
        //assertThat(response.size()).isGreaterThan(0);
        assertTrue(response.isEmpty());
    }

    @Test
    void findByEmailContainsTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByEmailContains(email);

        // validar
        //assertThat(response.size()).isGreaterThan(0);
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByEmailContainsNotFoundTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "uma-palavra";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByEmailContains(busca);

        // validar
        assertTrue(response.isEmpty());

    }

    @Test
    void findByNomeContainsOrEmailContainsWhenNomeTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "nome";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeContainsOrEmailContains(busca, busca);

        // validar
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByNomeContainsOrEmailContainsWhenEmailTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "email";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeContainsOrEmailContains(busca, busca);

        // validar
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByNomeContainsOrEmailContainsnotFindTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "uma-outra-palavra";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeContainsOrEmailContains(busca, busca);

        // validar
        assertTrue(response.isEmpty());
    }

    /////


    @Test
    void findByNomeStartsWithOrEmailEndsWithWhenNomeStartsTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "no";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeStartsWithOrEmailEndsWith(busca, busca);

        // validar
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByNomeStartsWithOrEmailEndsWithWhenEmailEndsTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "il";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeStartsWithOrEmailEndsWith(busca, busca);

        // validar
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0).getNome()).isEqualTo(usuarioModel.getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(usuarioModel.getEmail());
    }

    @Test
    void findByNomeStartsWithOrEmailEndsWithNotFindTest(){

        // dado que
        final var nome = "nome";
        final var email = "email";
        final var busca = "uma-outra-palavra";

        final var usuarioModel = createUsuarioModelMock(null,nome, email);

        // quando
        final var userSaved = mongoTemplate.insert(usuarioModel);

        //então
        final var response = repository.findByNomeStartsWithOrEmailEndsWith(busca, busca);

        // validar
        assertTrue(response.isEmpty());
    }

    private UsuarioModel createUsuarioModelMock(String id, String nome, String email){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setEmail(email);

        return usuarioModel;
    }

}