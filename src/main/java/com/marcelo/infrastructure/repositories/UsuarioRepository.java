package com.marcelo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.domain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

}
