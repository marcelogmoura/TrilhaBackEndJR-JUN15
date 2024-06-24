package com.marcelo.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;
import com.marcelo.domain.interfaces.UsuarioDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDomainService usuarioDomainService;
	
	@PostMapping("criar")
	public ResponseEntity<CriarUsuarioResponseDto> criarUsuario (@RequestBody @Valid CriarUsuarioRequestDto dto) {
		CriarUsuarioResponseDto response = usuarioDomainService.criarUsuario(dto);
		
		return ResponseEntity.status(201).body(response);
		
		
	}

}
