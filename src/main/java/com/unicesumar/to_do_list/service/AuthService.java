/*
 * 
 * @MariMaestri
 * 
 */

package com.unicesumar.to_do_list.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.unicesumar.to_do_list.model.Usuario;;

@Service
public class AuthService {
    
    private final List<Usuario> usuarios = new ArrayList<>();

    public boolean adicionarUsuario(Usuario usuario) {
        usuario.setId(usuarios.size() + 1);
        usuarios.add(usuario);
        return true;
    }

    public Usuario autenticarUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email) && 
                usuario.getSenha().equalsIgnoreCase(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean emailJaCadastrado(String email) {
        return usuarios.stream()
            .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }    
}
