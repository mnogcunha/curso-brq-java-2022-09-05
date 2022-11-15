package com.brq.ms05.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class UsuarioModel {

    @Id
    private String id;
    private String nome;
    private String email;

}
