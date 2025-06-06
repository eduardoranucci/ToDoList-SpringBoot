/*
 * 
 * @LucasLeffel
 * 
 */

package com.unicesumar.to_do_list.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Tarefa buscarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        return tarefa;
    }

    public void concluirTarefa(Tarefa tarefa) {
        tarefa.setConcluida(true);
        tarefa.setDataConclusao(LocalDate.now());
        tarefaRepository.save(tarefa);
    }

    @Transactional
    public void deletarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa != null) {
            Usuario usuario = tarefa.getUsuario();
            if (usuario != null) {
                usuario.listarTarefas().remove(tarefa);
            }
            tarefaRepository.deleteById(id);
        }
    }
}
