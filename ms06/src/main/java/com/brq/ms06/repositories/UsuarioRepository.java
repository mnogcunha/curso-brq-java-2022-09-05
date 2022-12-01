package com.brq.ms06.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brq.ms06.models.UsuarioModel;

@Repository
public interface UsuarioRepository
		extends CrudRepository<UsuarioModel, String> {

	List<UsuarioModel> findByNome(String nome);

	Page<UsuarioModel> findByEmail(String email, Pageable pageable);
}