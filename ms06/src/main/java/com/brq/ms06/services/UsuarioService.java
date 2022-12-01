package com.brq.ms06.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.brq.ms06.enums.MensagensExceptionEnum;
import com.brq.ms06.exceptions.NaoAcheiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	@Override
	public List<UsuarioDTO> findByNome(String nome){

		final var dtos = repository.findByNome(nome);

		return dtos.stream()
				.map( UsuarioModel::toDTO )
				.collect(Collectors.toList());
	}

	@Override
	public List<UsuarioDTO> findByAllAttrs(String input){

		final var list = (List<UsuarioModel>) repository.findAll();

		return list.stream()
				.filter( element -> element.getNome().contains(input) || element.getEmail().contains(input) )
				.map( UsuarioModel::toDTO)
				.collect(Collectors.toList());

	}

	@Override
	public void insertMany(int times) {

		List<UsuarioModel> list = new ArrayList<>();

		for (int i = 0; i < times; i++) {

			final var u = UsuarioModel
					.builder()
					.nome("Usuario " + i)
					//.email("usuario"+i+"@gmail.com")
					.email("usuario@gmail.com")
					.build();
			//repository.save(u);
			list.add(u);
		}

		repository.saveAll(list);
	}

	public Page<UsuarioModel> findByEmail(String email){

		final var pageRequest = PageRequest.of(0, 3);

		Page<UsuarioModel> response = repository.findByEmail(email, pageRequest);

		return response;
	}

	public void deleteAll() {
		repository.deleteAll();
	}
}