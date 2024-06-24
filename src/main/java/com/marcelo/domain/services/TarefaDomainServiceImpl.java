package com.marcelo.domain.services;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.marcelo.domain.dtos.ConsultarTarefaResponseDto;
import com.marcelo.domain.dtos.CriarTarefaRequestDto;
import com.marcelo.domain.dtos.EditarTarefaRequestDto;
import com.marcelo.domain.interfaces.TarefaDomainService;

public class TarefaDomainServiceImpl implements TarefaDomainService{

	@Override
	public ConsultarTarefaResponseDto criarTarefa(CriarTarefaRequestDto dto, UUID idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultarTarefaResponseDto editarTarefa(EditarTarefaRequestDto dto, UUID idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultarTarefaResponseDto excluirTarefa(UUID idTarefa, UUID idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultarTarefaResponseDto obter(UUID idTarefa, UUID idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConsultarTarefaResponseDto> consultarTarefas(Instant dataMin, Instant dataMax, UUID idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
