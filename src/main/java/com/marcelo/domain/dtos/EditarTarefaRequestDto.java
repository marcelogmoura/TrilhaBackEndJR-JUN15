package com.marcelo.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditarTarefaRequestDto {
	
	@NotNull(message = "Informe o ID da tarefa")
	private UUID idTarefa;
	
	@Size(min = 3, max = 100 , message = "Nome da TAREFA deve ter de 3 a 100 caracteres")
	@NotEmpty(message = "NOME não pode ser vazio.")
	private String nome;
	
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Informe a DATA no formato 'yyyy-MM-dd'.")
	@NotEmpty(message = "DATA não pode ser vazia.")
	private String data;
	
	@Pattern(regexp = "\\d{2}:\\d{2}",	message = "Informe a HORA no formato 'HH-mm'.")
	@NotEmpty(message = "Informe a HORA da tarefa.")
	private String hora;
	
	@NotNull(message = "PRIORIDADE não pode ser vazia.")
	private Integer prioridade;

}
