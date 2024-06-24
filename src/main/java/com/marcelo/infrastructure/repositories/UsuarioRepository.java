package com.marcelo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcelo.domain.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	@Query("SELECT u FROM tb_usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM tb_usuario u WHERE u.email = :email AND u.senha = :senha")
    Usuario findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);



}




