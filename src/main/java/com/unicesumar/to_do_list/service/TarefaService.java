/*
 * 
 * @LucasLeffel
 * 
 */

package com.unicesumar.to_do_list.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicesumar.to_do_list.model.Tarefa;

@Service
public class TarefaService {
    
    private final List<Tarefa> tarefas = new ArrayList<>();

    public boolean adicionarTarefa(Tarefa tarefa, int usuarioId){
        tarefa.setId(tarefas.size() + 1);
        tarefa.setUsuarioId(usuarioId);
        tarefa.setDataCriacao(LocalDate.now());
        tarefas.add(tarefa);
        return true;
    }
    
    public List<Tarefa> listarTarefas(int id) {
        List <Tarefa> tarefasUsuario = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (id == tarefa.getUsuarioId()) {
                tarefasUsuario.add(tarefa);
            }
        } 
        return tarefasUsuario;
    }
    
    public Tarefa buscarTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;            
            }
        }
        return null;
    }

    public void concluirTarefa(Tarefa tarefa) {
        for (int i = 0 ; i < tarefas.size() ; i++) {
            if (tarefas.get(i).getId() == tarefa.getId()) {
                tarefas.set(i, tarefa);
                break;        
            }
        }
    }
}
