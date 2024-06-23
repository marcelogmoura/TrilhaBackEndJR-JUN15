package com.marcelo.domain.entities;

import java.util.UUID;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Usuario {
	
	@Id
	private UUID idUsuario;
	
	private String nome;
	
	private String email;
	
	private String senha;

}
