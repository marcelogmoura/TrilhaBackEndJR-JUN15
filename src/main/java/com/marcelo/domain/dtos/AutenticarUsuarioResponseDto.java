package com.marcelo.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class AutenticarUsuarioResponseDto {
	
	private UUID idUsuario;
	private String nome;
	private String email;
	private String accessToken;

}
