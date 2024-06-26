package com.marcelo.domain.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_tarefa")
public class Tarefa {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID idTarefa;
	
	private String nome;
	
	private LocalDate data;
	
	private LocalTime hora;
	
	private Integer prioridade;

	@ManyToOne
	private Usuario usuario;


}
