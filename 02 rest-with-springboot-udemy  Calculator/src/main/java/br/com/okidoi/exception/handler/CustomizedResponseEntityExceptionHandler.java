package br.com.okidoi.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.okidoi.exception.ExceptionResponse;
import br.com.okidoi.exception.ResourceNofFoundException;

@ControllerAdvice
@Controller
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)  //Captura toda Exception e retornar uma mensagem de erro interna do servidor com data, mensagem e descrição
	public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	
	@ExceptionHandler(ResourceNofFoundException.class) //Captura minhas exceptions do tiop Unsuported Math Operation para tratar  
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST); 
	}	
}
