package com.brq.ms01.dtos;

import com.brq.ms01.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private int id;

    @NotEmpty(message = "Campo não pode ser branco")
    @NotNull(message = "Preenchimento Obrigatório")
    @Length(min=3, max=50, message = "O número de caracteres pode ser entre 3 e 50")
    private String nome;
    private String email;

    @Pattern(regexp = "^\\([1-9]{2}\\) [9]{0,1}[6-9]{1}[0-9]{3}\\-[0-9]{4}$", message = "Telefone inválido")
    private String telefone;

    public UsuarioModel toModel(){
        ModelMapper mapper = new ModelMapper();
        UsuarioModel model = mapper.map(this , UsuarioModel.class );
        return model;
    }
}