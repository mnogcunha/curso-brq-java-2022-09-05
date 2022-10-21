package com.brq.ms01.models;

import com.brq.ms01.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

/*
 * @Data, que faz o papel dos Getters, Setters e toString()
 * @Entity "diz" que a classe UsuarioModel vai ser mapeada com uma tabela no banco de dados
 * @Table especifica o nome da tabela que esta classe vai mapear
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "nome_user")
    private String nome;

    @Column(name = "email_user")
    private String email;

    @Column(name = "telefone_user")
    private String telefone;

    public UsuarioDTO toDTO() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, UsuarioDTO.class);
    }
}
