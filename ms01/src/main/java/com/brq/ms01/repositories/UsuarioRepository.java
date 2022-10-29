package com.brq.ms01.repositories;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    //    SELECT * FROM usuarios u
    //    where u.nome_user = '';
    List<UsuarioModel> findByNomeContains(String nome);

    // JPQL
    // SELECT u FROM UsuarioModel u WHERE u.nome like ?
    @Query("SELECT u FROM UsuarioModel u WHERE u.nome like :nomeBusca")
    List<UsuarioModel> findByNomeLike(@Param("nomeBusca") String nome);
    @Query(value = "SELECT * FROM usuarios u WHERE u.nome_user like :nomeBusca", nativeQuery = true)
    List<UsuarioModel> findByNomeLikeRawQuery(@Param("nomeBusca") String nome);
    List<UsuarioModel> findByNomeContainsAndEmailContains(String nome, String email);
    List<UsuarioModel> findByNomeContainsAndEmailContainsAndEnderecoRuaContains(String nome, String email, String rua);

}
