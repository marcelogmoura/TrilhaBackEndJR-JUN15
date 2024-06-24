package com.marcelo.infrastructure.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marcelo.domain.exceptions.EmailJaCadastradoException;

@ControllerAdvice
public class EmailJaCadastradoExceptionHandler {

	@ExceptionHandler(EmailJaCadastradoException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public List<String> errorHandler(EmailJaCadastradoException e) {
		
		List<String> errors = new ArrayList<String>();
		
		errors.add(e.getMessage());
		
		return errors;
	}

}
