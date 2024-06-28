package com.marcelo.infrastructure.repositories;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcelo.domain.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, UUID>{
	    
    @Query("SELECT t FROM tb_tarefa t WHERE t.idTarefa = :tarefaId AND t.usuario.id = :usuarioId")
    Tarefa findByIds(@Param("tarefaId") UUID tarefaId, @Param("usuarioId") UUID usuarioId);

    @Query("SELECT t FROM tb_tarefa t WHERE t.data >= :dataMin AND t.data <= :dataMax AND t.usuario.idUsuario = :pessoaId")
    List<Tarefa> findByDatas(@Param("dataMin") Instant dataMin, @Param("dataMax") Instant dataMax, @Param("pessoaId") UUID pessoaId);

}


