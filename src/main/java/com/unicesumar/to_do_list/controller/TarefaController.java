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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unicesumar.to_do_list.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class TarefaController {
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            model.addAttribute("msg", "Sessão expirou ou usuário deslogado");
            return "index";
        }
        model.addAttribute("nomeUsuario", usuario.getNome());
        return "home";
    }
}
