/*
 * 
 * @eduardoranucci
 * 
 */

package com.unicesumar.to_do_list.model;

public class Usuario {
    
    private int id;
    private String email;
    private String senha;
    private String nome;
    
    // getter id
    public int getId() {
        return id;
    }

    // getter e setter email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    // getter e setter senha
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // getter e setter nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
