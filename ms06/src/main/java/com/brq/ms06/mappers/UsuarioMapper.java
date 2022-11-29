package com.brq.ms06.mappers;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO convertModelToDTO(UsuarioModel m){
        final var mapper = new ModelMapper();
        return mapper.map(m,UsuarioDTO.class);
    }
}