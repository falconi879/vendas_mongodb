package br.com.jawebsites.vendasMongo.resources.exception;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jawebsites.vendasMongo.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objctNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError error = new StandarError(System.currentTimeMillis(), status.value(),"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

}
