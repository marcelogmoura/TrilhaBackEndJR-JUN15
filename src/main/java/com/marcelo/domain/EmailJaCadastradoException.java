package com.marcelo.domain;

public class EmailJaCadastradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmailJaCadastradoException() {	
		super("Esse email não está disponível.");
	}

}
