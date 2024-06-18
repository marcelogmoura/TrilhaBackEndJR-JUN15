package br.janioofi.task.domain.services;

import br.janioofi.task.domain.dtos.LoginResponseDto;
import br.janioofi.task.domain.dtos.UsuarioDto;
import br.janioofi.task.domain.dtos.UsuarioLoginDto;
import br.janioofi.task.domain.entities.Usuario;
import br.janioofi.task.domain.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository repository;
    private final TokenService tokenService;

    public LoginResponseDto login(@Valid UsuarioLoginDto user){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(user.usuario(), user.senha());
        var auth = authenticationManager.authenticate(usuarioSenha);
        var token = tokenService.generateToken((Usuario)auth.getPrincipal());
        return new LoginResponseDto(token);
    }

    public String register(UsuarioLoginDto user){
        if(this.repository.findByUsuario(user.usuario()) != null){
            throw new DataIntegrityViolationException("Já existe um usuário cadastrado com o mesmo nome");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.senha());
        Usuario data = new Usuario(null, user.usuario(), encryptedPassword);
        repository.save(data);
        return "Usuario registrado com sucesso";
    }
}