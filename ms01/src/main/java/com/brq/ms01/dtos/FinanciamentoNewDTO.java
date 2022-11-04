package com.brq.ms01.dtos;

import com.brq.ms01.models.FinanciamentoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanciamentoNewDTO {

    private Integer id;
    private Integer numeroContrato;
    private Double valor;

    private Integer user;

    public FinanciamentoModel toModel(){

        ModelMapper mapper = new ModelMapper();

        FinanciamentoModel model = mapper.map(this , FinanciamentoModel.class );

        return model;
    }
}