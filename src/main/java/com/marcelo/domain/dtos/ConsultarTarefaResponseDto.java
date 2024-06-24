package com.marcelo.domain.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ConsultarTarefaResponseDto {
	
	private UUID idTarefa;
	
	private String nome;
	
	private String  data;
	
	private String hora;
	
	private Integer prioridade;
	
	

}
