package com.marcelo.domain.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Usuario {
	
	private UUID idUsuario;
	
	private String nome;
	
	private String email;
	
	private String senha;

}
