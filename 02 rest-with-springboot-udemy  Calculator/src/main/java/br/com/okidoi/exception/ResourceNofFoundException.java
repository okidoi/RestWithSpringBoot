package br.com.okidoi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNofFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNofFoundException(String exception) {
		super(exception);
	}

	
	
	

}
