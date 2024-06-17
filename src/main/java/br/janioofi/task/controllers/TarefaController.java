package br.janioofi.task.controllers;

import br.janioofi.task.domain.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tarefa")
public class TarefaController {
    private final TarefaService service;

}
