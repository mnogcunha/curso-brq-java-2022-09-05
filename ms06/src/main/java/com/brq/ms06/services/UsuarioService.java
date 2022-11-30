package com.brq.ms06.services;

import java.util.List;
import java.util.stream.Collectors;

import com.brq.ms06.enums.MensagensExceptionEnum;
import com.brq.ms06.exceptions.NaoAcheiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<UsuarioDTO> getAll() {

		final var list = (List<UsuarioModel>) repository.findAll();

		return list
				.stream()
				.map( UsuarioModel::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO getOne(String id) {

		final var response = repository.findById(id)
				.orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()));

		return response.toDTO();
	}

	@Override
	public UsuarioDTO create(UsuarioModel model) {

		return repository.save(model).toDTO();
	}

	@Override
	public UsuarioDTO update(String id, UsuarioDTO dto) {

		final var response = repository.findById(id)
				.orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()));

		response.setEmail(dto.getEmail());
		response.setNome(dto.getNome());

		return repository.save(response).toDTO();
	}

	@Override
	public void delete(String id) {

		final var response = repository.findById(id)
				.orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()));

		repository.deleteById(response.getId());
	}

	public List<UsuarioDTO> findByNome(String nome){

		final var dtos = repository.findByNome(nome);

		return dtos.stream()
				.map( UsuarioModel::toDTO )
				.collect(Collectors.toList());
	}

	public List<UsuarioDTO> findByAllAttrs(String input){
		final var dtos = repository.findByNomeContainsOrEmailContains(input, input);

		return dtos.stream()
				.map( UsuarioModel::toDTO )
				.collect(Collectors.toList());
	}
}