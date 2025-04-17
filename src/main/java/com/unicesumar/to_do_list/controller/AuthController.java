/* 
 * 
 * @MariMaestri
 * - Rota para login do usuário
 * - Rota para validar login
 * - Rota para cadastro do usuário
 * - Rota para validar cadastro (colocar no arraylist)
 * - Rota para logout
 * 
*/

package com.unicesumar.to_do_list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }
    
}
