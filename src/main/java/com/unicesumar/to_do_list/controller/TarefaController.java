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
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TarefaController {
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
