package com.unicesumar.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicesumar.to_do_list.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByEmailAndSenha(String login, String senha);
    
    Usuario findByNome(String nome);
    boolean existsByEmail(String email);
}
