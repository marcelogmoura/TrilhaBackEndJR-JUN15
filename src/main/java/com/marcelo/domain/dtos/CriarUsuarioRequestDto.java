package com.marcelo.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {
	
	@Size(min = 3, max = 100 , message = "NOME deve ter 3 a 100 caracteres")
	@NotEmpty(message = "NOME não pode ser vazio.")
	private String nome;
	
	@Email(message = "Informe um EMAIL válido.")
	@NotEmpty(message = "EMAIL não pode ser vazio.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
			message = "A SENHA deve conter letras maiúsculas, minúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotEmpty(message = "SENHA não pode ser vazio.")
	private String senha;

}
