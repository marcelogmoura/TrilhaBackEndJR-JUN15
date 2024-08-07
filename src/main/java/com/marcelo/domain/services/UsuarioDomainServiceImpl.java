package com.marcelo.domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.domain.dtos.AutenticarUsuarioRequestDto;
import com.marcelo.domain.dtos.AutenticarUsuarioResponseDto;
import com.marcelo.domain.dtos.CriarUsuarioRequestDto;
import com.marcelo.domain.dtos.CriarUsuarioResponseDto;
import com.marcelo.domain.dtos.UsuarioGetDto;
import com.marcelo.domain.entities.Usuario;
import com.marcelo.domain.exceptions.AcessoNegadoException;
import com.marcelo.domain.exceptions.EmailJaCadastradoException;
import com.marcelo.domain.exceptions.SemResultadoException;
import com.marcelo.domain.interfaces.UsuarioDomainService;
import com.marcelo.infrastructure.components.CryptoSHA256Component;
import com.marcelo.infrastructure.components.TokenComponent;
import com.marcelo.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioDomainServiceImpl implements UsuarioDomainService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CryptoSHA256Component cryptoSHA256Component;
	
	@Autowired
	private TokenComponent tokenComponent;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto) {
		
		if(usuarioRepository.findByEmail(dto.getEmail()) != null)
			throw new EmailJaCadastradoException();
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(UUID.randomUUID());
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(cryptoSHA256Component.encrypt(dto.getSenha()));
		
		usuarioRepository.save(usuario);
		
		CriarUsuarioResponseDto response = new CriarUsuarioResponseDto();
		response.setIdUsuario(usuario.getIdUsuario());
		response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
		response.setDataHoraCadastro(new Date());
		
		
		return response;
	}

	@Override
	public AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto) {
		
		Usuario usuario = usuarioRepository.findByEmailAndSenha(dto.getEmailAcesso(), cryptoSHA256Component.encrypt(dto.getSenhaAcesso()));
		
		if(usuario == null)
			throw new AcessoNegadoException();
		
		AutenticarUsuarioResponseDto response = new AutenticarUsuarioResponseDto();
		
		response.setIdUsuario(usuario.getIdUsuario());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setAccessToken(tokenComponent.generateToken(usuario.getIdUsuario()));
		
		return response;
	}

	@Override
	public List<UsuarioGetDto> listarUsuarios() {
		
		List<UsuarioGetDto> lista = new ArrayList<UsuarioGetDto>();
				
		for(Usuario usuario : usuarioRepository.findAll()) {
			
			UsuarioGetDto dto = new UsuarioGetDto();
			
			dto.setIdUsuario(usuario.getIdUsuario());
			dto.setNome(usuario.getNome());
			dto.setEmail(usuario.getEmail());
	
			lista.add(dto);
				
		}
		
	    if (lista.isEmpty()) {
	        throw new SemResultadoException();
	    }
		
		return lista;
	}



}
