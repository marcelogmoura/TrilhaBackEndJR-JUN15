package com.marcelo.application.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tarefas")
public class TarefaController {
	
	@PostMapping("criar")
	public void criarTarefa() {
		
	}
	
	@PutMapping("editar")
	public void editarTarefa() {
		
	}
	
	@DeleteMapping("excluir/{id}")
	public void excluirTarefa(@PathVariable("id") UUID idTarefa) {
		
	}
	
	@GetMapping("consultar/{dataMin}/{dataMax}")
	public void consultarTarefas(
			@PathVariable("dataMin") String dataMin,
			@PathVariable("dataMax") String dataMax) {
		
	}
	
	@GetMapping("obter/{id}")
	public void obterTarefa(@PathVariable("id") UUID idTarefa) {
		
	}
	
}
