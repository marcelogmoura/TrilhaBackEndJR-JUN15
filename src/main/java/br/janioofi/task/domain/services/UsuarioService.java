package br.janioofi.task.domain.services;

import br.janioofi.task.domain.dtos.UsuarioDto;
import br.janioofi.task.domain.entities.Usuario;
import br.janioofi.task.domain.repositories.UsuarioRepository;
import br.janioofi.task.exceptions.RecordNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {
    private final UsuarioRepository repository;

    public List<UsuarioDto> findAll(){
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id){
        validaDelete(id);
        log.info("Deletando usuário com  ID: " + id);
        repository.deleteById(id);
    }

    public UsuarioDto update(@Valid Long id, UsuarioDto user){
        validaUsuario(user);

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.senha());

        Usuario usuario = repository.findById(id).map(recordFound -> {
            recordFound.setUsuario(user.usuario());
            recordFound.setSenha(encryptedPassword);
            return repository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException("Nenhum usuário encontrado com o ID: " + id));

        log.info("Atualizando usuário com  ID:  " + id);
        return this.toDto(usuario);
    }

    private void validaUsuario(UsuarioDto objDTO) {
        Optional<Usuario> obj = repository.findByUsuario(objDTO.usuario());

        if (obj.isPresent() && !obj.get().getIdUsuario().equals(objDTO.id())) {
            throw new DataIntegrityViolationException("Usuário já existe no sistema!");
        }
    }

    private void validaDelete(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isPresent() && usuario.get().getUsuario().equalsIgnoreCase("admin")){
            throw new DataIntegrityViolationException("Usuário admin não pode ser deletado");
        }else if(usuario.isEmpty()){
            throw new RecordNotFoundException("Nenhum usuário com este ID");
        }
    }

    private UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getIdUsuario(), usuario.getUsuario(), usuario.getSenha());
    }
}
