package com.brq.ms01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsorcioDTO {

    private int id;
    private String nome;
    private String tipo;
    private Double valor;

}