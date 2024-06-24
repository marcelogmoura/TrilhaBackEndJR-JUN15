package com.marcelo.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutenticarUsuarioRequestDto {
	
	@Email(message = "Informe um EMAIL válido.")
	@NotEmpty(message = "EMAIL não pode ser vazio.")
	private String emailAcesso;
	
	@Size( message = "Informe ao menos 8 caracteres.")
	@NotEmpty(message = "SENHA não pode ser vazio.")
	private String senhaAcesso;

}
