package com.marcelo.domain.interfaces;

import com.marcelo.domain.dtos.AutenticarUsuarioRequestDto;
import com.marcelo.domain.dtos.AutenticarUsuarioResponseDto;
import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;

public interface UsuarioDomainService {
	
	CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto);
	
	AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto);

}
