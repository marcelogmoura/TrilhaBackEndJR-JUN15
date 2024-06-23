package com.marcelo.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Tarefa {
	
	private UUID idTarefa;
	
	private String nome;
	
	private LocalDate data;
	
	private LocalDateTime hora;
	
	private Integer prioridade;

}
