package com.marcelo.application.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.domain.dtos.AutenticarUsuarioRequestDto;
import com.marcelo.domain.dtos.AutenticarUsuarioResponseDto;
import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;
import com.marcelo.domain.dtos.UsuarioGetDto;
import com.marcelo.domain.interfaces.UsuarioDomainService;
import com.marcelo.infrastructure.components.TokenComponent;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDomainService usuarioDomainService;
	
	@Autowired
	private TokenComponent tokenComponent;
	
	@PostMapping("criar")
	public ResponseEntity<CriarUsuarioResponseDto> criarUsuario (@RequestBody @Valid CriarUsuarioRequestDto dto) {
		CriarUsuarioResponseDto response = usuarioDomainService.criarUsuario(dto);		
		return ResponseEntity.status(201).body(response);
	}
	
	@PostMapping("autenticar")
	public ResponseEntity<AutenticarUsuarioResponseDto> autenticarUsuario(@RequestBody @Valid AutenticarUsuarioRequestDto dto ) {
		AutenticarUsuarioResponseDto response = usuarioDomainService.autenticarUsuario(dto);		
		return ResponseEntity.status(200).body(response); 		
	}
	
	@GetMapping
	public List<UsuarioGetDto> listarUsuarios(HttpServletRequest request) {
		return usuarioDomainService.listarUsuarios();
	}
	
	
	private UUID getIdUsuario(HttpServletRequest request) {
		String token = request.getHeader("Authorization").replace("Bearer", "").trim();
		return tokenComponent.getIdFromToken(token);
	}
	

}


