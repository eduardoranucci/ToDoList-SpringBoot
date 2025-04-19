/*
 * 
 * @eduardoranucci
 * 
 */

package com.unicesumar.to_do_list.model;

public class Tarefa {

    private int id;
    private int usuarioId;
    private String descricao;
    private boolean concluida;
    private String dataCriacao;
    private String dataConclusao;
    
    public Tarefa() {}

    public Tarefa(int id, int usuarioId, String descricao, boolean concluida, String dataCriacao,
            String dataConclusao) {
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
    
    public int getUsuarioId() {
        return usuarioId;
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
    
    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
