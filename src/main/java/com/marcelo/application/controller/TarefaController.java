package com.marcelo.application.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.domain.dtos.ConsultarTarefaResponseDto;
import com.marcelo.domain.dtos.CriarTarefaRequestDto;
import com.marcelo.domain.interfaces.TarefaDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/tarefas")
public class TarefaController {
	
	
	@Autowired
	private TarefaDomainService tarefaDomainService;
	
	
	@PostMapping("criar")
	public ResponseEntity<ConsultarTarefaResponseDto> criarTarefa(@RequestBody @Valid CriarTarefaRequestDto dto) {
		return null;
		
	}
	
	@PutMapping("alterar")
	public ResponseEntity<ConsultarTarefaResponseDto>  alterarTarefa(@RequestBody @Valid CriarTarefaRequestDto dto) {
		return null;
	}
	
	@DeleteMapping("excluir/{id}")
	public ResponseEntity<ConsultarTarefaResponseDto> excluirTarefa(@PathVariable("id") UUID idTarefa) {
		return null;
	}
	
	@GetMapping("consultar/{dataMin}/{dataMax}")
	public ResponseEntity<List<ConsultarTarefaResponseDto>> consultarTarefas(
			@PathVariable("dataMin") String dataMin,
			@PathVariable("dataMax") String dataMax) {	
		
		return null;
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<ConsultarTarefaResponseDto> obterTarefa(@PathVariable("id") UUID idTarefa) {
		return null;
	}
	
}
