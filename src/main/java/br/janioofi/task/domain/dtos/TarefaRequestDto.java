package br.janioofi.task.domain.dtos;

import br.janioofi.task.domain.enums.Status;

public record TarefaRequestDto(
        Long idTarefa,
        String descricao,
        Status status) {
}
