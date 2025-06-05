/*
 * 
 * @LucasLeffel
 * - Rota para listar as tarefas (home)
 * - Rota para cadastro de tarefa
 * - Rota para validar cadastro (colocar no arraylist)
 * - Rota para concluir a tarefa
 * 
 */

package com.unicesumar.to_do_list.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unicesumar.to_do_list.model.Tarefa;
import com.unicesumar.to_do_list.model.Usuario;
import com.unicesumar.to_do_list.service.TarefaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        
        List<Tarefa> tarefas = tarefaService.listarTarefas(usuario.getId());
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("usuario", usuario);
        return "home";
    }

    @PostMapping("/adicionarTarefa")
    public String adicionarTarefa(HttpSession session, @ModelAttribute Tarefa tarefa, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        tarefaService.adicionarTarefa(tarefa, usuario.getId());
        return "redirect:/home";
    }

    @PostMapping("/concluirTarefa")
    public String concluirTarefa(@RequestParam("id") int id, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        
        Tarefa tarefa = tarefaService.buscarTarefa(id);
        if (tarefa != null) {
            tarefa.setConcluida(true);
            tarefa.setDataConclusao(LocalDate.now());
            tarefaService.concluirTarefa(tarefa);
        }

        List<Tarefa> tarefas = tarefaService.listarTarefas(usuario.getId());
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("nomeUsuario", usuario.getNome());

        return "redirect:/home";
    }
    
}
