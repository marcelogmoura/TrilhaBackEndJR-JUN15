package com.marcelo.domain.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.domain.dtos.ConsultarTarefaResponseDto;
import com.marcelo.domain.dtos.CriarTarefaRequestDto;
import com.marcelo.domain.dtos.EditarTarefaRequestDto;
import com.marcelo.domain.entities.Tarefa;
import com.marcelo.domain.entities.Usuario;
import com.marcelo.domain.exceptions.TarefaNaoLocalizadaException;
import com.marcelo.domain.interfaces.TarefaDomainService;
import com.marcelo.infrastructure.repositories.TarefaRepository;
import com.marcelo.infrastructure.repositories.UsuarioRepository;

@Service
public class TarefaDomainServiceImpl implements TarefaDomainService{
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ConsultarTarefaResponseDto criarTarefa(CriarTarefaRequestDto dto, UUID idUsuario) {
		
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		
		Tarefa tarefa = modelMapper.map(dto, Tarefa.class);
		tarefa.setIdTarefa(UUID.randomUUID());
		tarefa.setUsuario(usuario);
		
		tarefaRepository.save(tarefa);

	    return modelMapper.map(tarefa, ConsultarTarefaResponseDto.class);	
	}
	

	@Override
	public ConsultarTarefaResponseDto editarTarefa(EditarTarefaRequestDto dto, UUID idUsuario) {
		
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		
		Tarefa tarefa = modelMapper.map(dto, Tarefa.class);
		tarefa.setUsuario(usuario);
		
		tarefaRepository.save(tarefa);
		
		return modelMapper.map(tarefa, ConsultarTarefaResponseDto.class);	
	}
	

	@Override
	public ConsultarTarefaResponseDto excluirTarefa(UUID idTarefa, UUID idUsuario) {
		
	    Optional<Tarefa> tarefaOptional = tarefaRepository.findById(idTarefa);
	    if (!tarefaOptional.isPresent()) {
	        throw new TarefaNaoLocalizadaException();
	    }
		
		Tarefa tarefa  = tarefaRepository.findByIds(idTarefa, idUsuario);
		
		tarefaRepository.delete(tarefa);
		
		return modelMapper.map(tarefa, ConsultarTarefaResponseDto.class);	
	}
	

	@Override
	public ConsultarTarefaResponseDto obterTarefa(UUID idTarefa, UUID idUsuario) {
		

		Tarefa tarefa = tarefaRepository.findByIds(idTarefa, idUsuario);
		
		if(tarefa == null) {
			throw new TarefaNaoLocalizadaException();
		}
		
		return modelMapper.map(tarefa, ConsultarTarefaResponseDto.class);	
	}
	

	@Override
	public List<ConsultarTarefaResponseDto> consultarTarefas(Instant dataMin, Instant dataMax, UUID idUsuario) {
		
		LocalDate localDateMin = dataMin.atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDateMax = dataMax.atZone(ZoneId.systemDefault()).toLocalDate();

		List<Tarefa> tarefas = tarefaRepository.findByDatas(localDateMin, localDateMax, idUsuario);
		
		return tarefas
				.stream()
				.map(tarefa -> modelMapper
				.map(tarefa, ConsultarTarefaResponseDto.class))
				.collect(Collectors.toList());
		
	}

}



