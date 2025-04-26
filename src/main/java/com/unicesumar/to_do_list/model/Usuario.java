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
    private String cpf;
    private String perfil;
    
    public Usuario() {}
    
    public Usuario(int id, String email, String senha, String nome) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    // getter e setter id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    // getter e setter cpf
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // getter e setter perfil
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
