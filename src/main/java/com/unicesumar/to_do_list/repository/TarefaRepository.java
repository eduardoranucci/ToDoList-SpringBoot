package com.unicesumar.to_do_list.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicesumar.to_do_list.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Optional<Tarefa> findById(Long id);
    List<Tarefa> findByUsuarioIdAndConcluida(Long usuarioId, boolean concluida);
    List<Tarefa> findByUsuarioId(Long usuarioId);
}
