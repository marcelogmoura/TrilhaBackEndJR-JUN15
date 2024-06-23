package com.marcelo.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID idTarefa;
	
	private String nome;
	
	private LocalDate data;
	
	private LocalDateTime hora;
	
	private Integer prioridade;

	@ManyToOne
	private Usuario usuario;


}
