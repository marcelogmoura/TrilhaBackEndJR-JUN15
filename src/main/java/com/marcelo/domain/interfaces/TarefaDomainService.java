package com.marcelo.domain.interfaces;

import java.util.UUID;

import com.marcelo.domain.dtos.ConsultarTarefaResponseDto;
import com.marcelo.domain.dtos.CriarTarefaRequestDto;
import com.marcelo.domain.dtos.EditarTarefaRequestDto;

public interface TarefaDomainService {
	
	ConsultarTarefaResponseDto criarTarefa(CriarTarefaRequestDto dto, UUID idUsuario);
	
	ConsultarTarefaResponseDto editarTarefa(EditarTarefaRequestDto dto, UUID idUsuario);

}
