package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
    private int id;
    private String nome;
    private String email;
    /*
    // Construtor
    UsuarioModel() {}
    UsuarioModel( int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    // Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    */

}
