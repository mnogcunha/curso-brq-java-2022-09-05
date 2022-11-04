package com.brq.ms01.models;

import com.brq.ms01.dtos.ConsorcioDTO;
import com.brq.ms01.dtos.FinanciamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consorcios")
public class ConsorcioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consorcio")
    private int id;

    @Column(name = "nome_consorcio")
    private String nome;

    @Column(name = "tipo_consorcio")
    private String tipo;

    @Column(name = "valor_consorcio")
    private Double valor;

    @ManyToMany(mappedBy = "consorcios")
    private List<UsuarioModel> usuarios;

    public ConsorcioDTO toDTO(){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, ConsorcioDTO.class);
    }
}