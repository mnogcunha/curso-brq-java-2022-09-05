package com.brq.ms06.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brq.ms06.models.UsuarioModel;

import java.util.List;

@Repository
public interface UsuarioRepository 
	extends CrudRepository<UsuarioModel, String>{

	List<UsuarioModel> findByNome(String nome);

	List<UsuarioModel> findByNomeContains(String nome);

	List<UsuarioModel> findByEmailContains(String email);

	List<UsuarioModel> findByNomeContainsOrEmailContains(String nome, String email);

	List<UsuarioModel> findByNomeStartsWithOrEmailEndsWith(String nome, String email);
	
}