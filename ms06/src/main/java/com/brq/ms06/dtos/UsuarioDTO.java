package com.brq.ms06.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.brq.ms06.models.UsuarioModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class UsuarioDTO {
	
	@Id
	private String id;
	
	@NotNull(message = "o campo nome não pode ser nulo")
    @NotEmpty(message = "o campo nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = "o campo email não pode ser nulo")
    @NotEmpty(message = "o campo email não pode ser vazio")
	private String email;	

	public UsuarioModel toModel(){
        final var mapper = new ModelMapper();
        return mapper.map(this, UsuarioModel.class);
    }
}
