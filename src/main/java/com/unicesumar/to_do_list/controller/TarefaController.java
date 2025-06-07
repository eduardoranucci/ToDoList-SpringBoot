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

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unicesumar.to_do_list.model.Tarefa;
import com.unicesumar.to_do_list.model.Usuario;
import com.unicesumar.to_do_list.repository.UsuarioRepository;
import com.unicesumar.to_do_list.service.TarefaService;

@Controller
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/home")
    public String home(Principal principal, Model model) {
        String email = principal.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);

        List<Tarefa> tarefas = tarefaService.listarTarefas(usuario.getId());
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("usuario", usuario);
        return "home";
    }

    @PostMapping("/adicionarTarefa")
    public String adicionarTarefa(Principal principal, @ModelAttribute Tarefa tarefa, Model model,
            RedirectAttributes attrs) {
        String email = principal.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);

        tarefaService.adicionarTarefa(tarefa, usuario.getId());
        attrs.addFlashAttribute("msgSuccess", "Tarefa criada com sucesso!");
        return "redirect:/home";
    }

    @PostMapping("/concluirTarefa")
    public String concluirTarefa(@RequestParam("id") Long id, Principal principal, Model model,
            RedirectAttributes attrs) {
        String email = principal.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);

        Tarefa tarefa = tarefaService.buscarTarefa(id);
        if (tarefa != null) {
            tarefa.setConcluida(true);
            tarefa.setDataConclusao(LocalDate.now());
            tarefaService.concluirTarefa(tarefa);
        }

        List<Tarefa> tarefas = tarefaService.listarTarefas(usuario.getId());
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("nomeUsuario", usuario.getNome());
        attrs.addFlashAttribute("msgSuccess", "Tarefa concluída com sucesso!");

        return "redirect:/home";
    }

    @PostMapping("/deletarTarefa")
    public String deletarTarefa(@RequestParam("id") Long id, Principal principal, RedirectAttributes attrs) {
        String email = principal.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);

        Tarefa tarefa = tarefaService.buscarTarefa(id);
        if (tarefa != null && tarefa.getUsuario().getId() == usuario.getId() && !tarefa.isConcluida()) {
            System.out.println("Entrou no deletarTarefa, id=" + id);
            tarefaService.deletarTarefa(id);
            attrs.addFlashAttribute("msgSuccess", "Tarefa deletada com sucesso!");
        } else {
            attrs.addFlashAttribute("msg", "Tarefa não encontrada ou já concluída!");
        }

        return "redirect:/home";
    }
}
