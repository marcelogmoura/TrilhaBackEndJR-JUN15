package br.janioofi.task.domain.dtos;

import br.janioofi.task.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TarefaResponseDto(
        Long idTarefa,
        String descricao,
        Status status,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dataCriacao,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dataAtualizacao) {
}
