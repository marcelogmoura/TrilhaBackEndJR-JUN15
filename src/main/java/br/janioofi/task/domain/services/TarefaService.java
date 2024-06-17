package br.janioofi.task.domain.services;

import br.janioofi.task.domain.dtos.TarefaRequestDto;
import br.janioofi.task.domain.dtos.TarefaResponseDto;
import br.janioofi.task.domain.entities.Tarefa;
import br.janioofi.task.domain.repositories.TarefaRepository;
import br.janioofi.task.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TarefaService {
    private final TarefaRepository repository;

    private static final String NENHUMA_TAREFA = "Nenhuma tarefa encontrada com ID: ";

    public List<TarefaResponseDto> findAll(){
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public TarefaResponseDto create(TarefaRequestDto tarefaRequestDto){
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(tarefaRequestDto.descricao());
        tarefa.setStatus(tarefaRequestDto.status());
        tarefa.setDataCriacao(LocalDateTime.now());
        tarefa.setDataAtualizacao(LocalDateTime.now());

        log.info("Criando nova tarefa com descrição: " + tarefa.getDescricao());

        return this.toDto(repository.save(tarefa));
    }

    public TarefaResponseDto update(TarefaRequestDto tarefaRequestDto, Long id){
        Tarefa tarefa = repository.findById(id).map(data -> {
            data.setDescricao(tarefaRequestDto.descricao());
            data.setStatus(tarefaRequestDto.status());
            data.setDataAtualizacao(LocalDateTime.now());
            return repository.save(data);
        }).orElseThrow(() -> new RecordNotFoundException(NENHUMA_TAREFA + id));

        log.info("Atualizando uma tarefa com ID: " + tarefa.getIdTarefa());

        return this.toDto(tarefa);
    }

    public void delete(Long id){
        Optional<Tarefa> tarefa = repository.findById(id);
        if(tarefa.isEmpty()) throw new RecordNotFoundException(NENHUMA_TAREFA + id);
        log.info("Deletando uma tarefa com ID: " + tarefa.get().getIdTarefa());
        repository.deleteById(id);
    }

    private TarefaResponseDto toDto(Tarefa tarefa){
        return new TarefaResponseDto(tarefa.getIdTarefa(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getDataCriacao(), tarefa.getDataAtualizacao());
    }

}
