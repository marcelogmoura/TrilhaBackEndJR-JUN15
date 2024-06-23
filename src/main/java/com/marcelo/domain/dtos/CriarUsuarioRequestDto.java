package com.marcelo.domain.dtos;

import lombok.Data;

@Data
public class CriarUsuarioRequestDto {
	
	private String nome;
	
	private String email;
	
	private String senha;

}
