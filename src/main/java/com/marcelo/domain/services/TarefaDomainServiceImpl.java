package com.marcelo.domain.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.marcelo.domain.dtos.ConsultarTarefaResponseDto;
import com.marcelo.domain.dtos.CriarTarefaRequestDto;
import com.marcelo.domain.dtos.EditarTarefaRequestDto;
import com.marcelo.domain.entities.Tarefa;
import com.marcelo.domain.entities.Usuario;
import com.marcelo.domain.interfaces.TarefaDomainService;
import com.marcelo.infrastructure.repositories.TarefaRepository;
import com.marcelo.infrastructure.repositories.UsuarioRepository;

public class TarefaDomainServiceImpl implements TarefaDomainService{
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public ConsultarTarefaResponseDto criarTarefa(CriarTarefaRequestDto dto, UUID idUsuario) {
		
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		
		Tarefa tarefa = new Tarefa();
		


		
		tarefa.setIdTarefa(UUID.randomUUID());
		tarefa.setUsuario(usuario);
		
		tarefaRepository.save(tarefa);

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
