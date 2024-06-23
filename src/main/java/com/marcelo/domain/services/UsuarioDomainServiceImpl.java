package com.marcelo.domain.services;

import org.springframework.stereotype.Service;

import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;
import com.marcelo.domain.interfaces.UsuarioDomainService;

@Service
public class UsuarioDomainServiceImpl implements UsuarioDomainService{

	@Override
	public CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto) {
		
		return null;
	}

}
