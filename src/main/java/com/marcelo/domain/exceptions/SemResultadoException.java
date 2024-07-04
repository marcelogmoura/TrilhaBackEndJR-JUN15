package com.marcelo.domain.exceptions;

public class SemResultadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SemResultadoException() {
		super("Não foi encontrado nenhum registro.");
	}

}
