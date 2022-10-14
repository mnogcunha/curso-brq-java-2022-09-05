package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "id_user")
    private int id;

    @Column(name = "nome_user")
    private String nome;

    @Column(name = "email_user")
    private String email;
}
