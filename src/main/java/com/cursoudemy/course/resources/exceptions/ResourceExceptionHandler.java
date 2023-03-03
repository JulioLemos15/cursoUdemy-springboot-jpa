package com.cursoudemy.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursoudemy.course.services.exceptions.DatabaseException;
import com.cursoudemy.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // intercepta as exeções que acontecerem para que esse objeto possa executar o
					// tratamento
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // Com essa anotação diz que esse meu motodo (resourceNotFound)
														// irá interceptar qualquer exeção desse tipo
														// (ResourceNotFoundException.class) que for lançada
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class) 
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
