package com.marcelo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.domain.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, UUID>{

}
