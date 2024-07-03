package com.marcelo.domain.interfaces;

import java.util.List;

import com.marcelo.domain.dtos.AutenticarUsuarioRequestDto;
import com.marcelo.domain.dtos.AutenticarUsuarioResponseDto;
import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;
import com.marcelo.domain.dtos.UsuarioGetDto;

public interface UsuarioDomainService {
	
	CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto);
	
	AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto);
	

	List<UsuarioGetDto> listarUsuarios();

}
