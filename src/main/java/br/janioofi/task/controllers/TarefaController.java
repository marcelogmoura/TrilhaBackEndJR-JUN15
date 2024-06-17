package br.janioofi.task.controllers;

import br.janioofi.task.domain.dtos.TarefaRequestDto;
import br.janioofi.task.domain.dtos.TarefaResponseDto;
import br.janioofi.task.domain.services.TarefaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Tarefa", description = "Tarefa API")
@RequestMapping("/api/tarefa")
public class TarefaController {
    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDto> create(@RequestBody TarefaRequestDto tarefaRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tarefaRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> update(@RequestBody TarefaRequestDto tarefaRequestDto, @PathVariable Long id){
        return ResponseEntity.ok().body(service.update(tarefaRequestDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
