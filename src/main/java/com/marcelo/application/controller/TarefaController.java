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
import com.marcelo.infrastructure.components.TokenComponent;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/tarefas")
public class TarefaController {
	
	
	@Autowired
	private TarefaDomainService tarefaDomainService;
	
	@Autowired
	private TokenComponent tokenComponent;
	
	
	@PostMapping("criar")
	public ResponseEntity<ConsultarTarefaResponseDto> criarTarefa
		(@RequestBody @Valid CriarTarefaRequestDto dto , HttpServletRequest request) {	
		
		UUID idUsuario = getIdUsuario(request);
		
		ConsultarTarefaResponseDto response = tarefaDomainService.criarTarefa(dto, idUsuario);		 
		return ResponseEntity.status(201).body(response);
		
	}
	
	@PutMapping("alterar")
	public ResponseEntity<ConsultarTarefaResponseDto>  alterarTarefa
		(@RequestBody @Valid CriarTarefaRequestDto dto, HttpServletRequest request) {
		return null;
	}
	
	@DeleteMapping("excluir/{id}")
	public ResponseEntity<ConsultarTarefaResponseDto> excluirTarefa
		(@PathVariable("id") UUID idTarefa, HttpServletRequest request) {
		return null;
	}
	
	@GetMapping("consultar/{dataMin}/{dataMax}")
	public ResponseEntity<List<ConsultarTarefaResponseDto>> consultarTarefas(
			@PathVariable("dataMin") String dataMin,
			@PathVariable("dataMax") String dataMax, 
			HttpServletRequest request) {	
		
		return null;
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<ConsultarTarefaResponseDto> obterTarefa
		(@PathVariable("id") UUID idTarefa, HttpServletRequest request) {
		return null;
	}
	
	private UUID getIdUsuario(HttpServletRequest request) {
		String token = request.getHeader("Authorization").replace("Bearer", "").trim();
		return tokenComponent.getIdFromToken(token);
	}
	
}


