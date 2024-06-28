package com.marcelo.domain.interfaces;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.marcelo.domain.dtos.ConsultarTarefaResponseDto;
import com.marcelo.domain.dtos.CriarTarefaRequestDto;
import com.marcelo.domain.dtos.EditarTarefaRequestDto;

public interface TarefaDomainService {
	
	ConsultarTarefaResponseDto criarTarefa(CriarTarefaRequestDto dto, UUID idUsuario);
	
	ConsultarTarefaResponseDto editarTarefa(EditarTarefaRequestDto dto, UUID idUsuario);
	
	ConsultarTarefaResponseDto excluirTarefa(UUID idTarefa, UUID idUsuario);
	
	ConsultarTarefaResponseDto obterTarefa(UUID idTarefa, UUID idUsuario);
	
	List<ConsultarTarefaResponseDto> consultarTarefas(Instant dataMin, Instant dataMax, UUID idUsuario);

}
