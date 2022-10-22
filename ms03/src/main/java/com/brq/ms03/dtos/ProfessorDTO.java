package com.brq.ms03.dtos;

import com.brq.ms03.models.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private int id;

    @Column(name = "nome_prof")
    private String nome;

    @Column(name = "cpf_prof")
    private String cpf;

    @Column(name = "salario_prof")
    private double salario;

    @Column(name = "telefone_prof")
    private String telefone;

    public ProfessorModel toModel(){
        ModelMapper mapper = new ModelMapper();
        ProfessorModel model = mapper.map(this , ProfessorModel.class );
        return model;
    }
}