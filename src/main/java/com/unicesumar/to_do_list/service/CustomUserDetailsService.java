package com.unicesumar.to_do_list.service;

import com.unicesumar.to_do_list.model.Usuario;
import com.unicesumar.to_do_list.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Tentando autenticar: " + email);
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        System.out.println("Usuário encontrado: " + usuario.getEmail());
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }
}