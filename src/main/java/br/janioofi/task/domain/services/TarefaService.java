package br.janioofi.task.domain.services;

import br.janioofi.task.domain.repositories.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;

}
