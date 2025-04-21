/*
 * 
 * @eduardoranucci
 * 
 */

package com.unicesumar.to_do_list.model;

import java.time.LocalDate;

public class Tarefa {

    private int id;
    private int usuarioId;
    private String descricao;
    private boolean concluida;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;

    public Tarefa() {}

    public Tarefa(int id, int usuarioId, String descricao, boolean concluida, LocalDate dataCriacao,
            LocalDate dataConclusao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.concluida = concluida;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int id) {
        this.usuarioId = id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public boolean isConcluida() {
        return concluida;
    }
    
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
