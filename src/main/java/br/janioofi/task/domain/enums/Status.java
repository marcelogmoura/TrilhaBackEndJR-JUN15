package br.janioofi.task.domain.enums;

public enum Status {
    PENDENTE(0, "PENDENTE"),
    CONCLUIDO(1, "CONCLUIDO"),
    CANCELADO(2, "CANCELADO");

    private final Integer code;
    private final String description;

    Status(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
