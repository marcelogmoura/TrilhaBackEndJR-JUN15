package com.marcelo.domain.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class CriarUsuarioResponseDto {
	
	private UUID idUsuario;
	
	private String nome;
	
	private String email;
	
	private Date dataHoraCadastro;

}
