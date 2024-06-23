package com.marcelo.domain.interfaces;

import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;

public interface UsuarioDomainService {
	
	CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto);

}
