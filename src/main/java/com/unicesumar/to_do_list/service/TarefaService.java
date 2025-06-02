/*
 * 
 * @LucasLeffel
 * 
 */

package com.unicesumar.to_do_list.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.to_do_list.model.Tarefa;
import com.unicesumar.to_do_list.model.Usuario;
import com.unicesumar.to_do_list.repository.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    public boolean adicionarTarefa(Tarefa tarefa, Long usuarioId){
        tarefa.setUsuario(new Usuario(usuarioId));
        tarefa.setDataCriacao(LocalDate.now());
        tarefaRepository.save(tarefa);
        return true;
    }

    public List<Tarefa> listarTarefas(Long usuarioId) {
        return tarefaRepository.findByUsuarioId(usuarioId);
    }

    public Tarefa buscarTarefa(int id) {
        Tarefa tarefa = tarefaRepository.findById((long) id).orElse(null);
        return tarefa;
    }

    public void concluirTarefa(Tarefa tarefa) {
        tarefa.setConcluida(true);
        tarefa.setDataConclusao(LocalDate.now());
        tarefaRepository.save(tarefa);
    }
}
