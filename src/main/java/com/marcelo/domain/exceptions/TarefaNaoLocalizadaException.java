package com.marcelo.domain.exceptions;

public class TarefaNaoLocalizadaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TarefaNaoLocalizadaException() {
		super("Tarefa não localizada, verifique os dados.");
	}

}
