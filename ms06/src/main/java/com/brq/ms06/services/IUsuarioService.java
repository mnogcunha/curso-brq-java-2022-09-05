package com.brq.ms06.services;

import java.util.List;
import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import org.springframework.data.domain.Page;

public interface IUsuarioService {
	
	 List<UsuarioDTO> getAll();

	 UsuarioDTO create(UsuarioModel model);

     UsuarioDTO update(String id, UsuarioDTO dto);

     void delete(String id);

	 UsuarioDTO getOne(String id);

	List<UsuarioDTO> findByNome(String nome);

	List<UsuarioDTO> findByAllAttrs(String input);

	void insertMany(int times);

	Page<UsuarioModel> findByEmail(String email);

	void deleteAll();
}