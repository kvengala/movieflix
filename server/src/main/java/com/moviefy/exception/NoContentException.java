package com.moviefy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException{

	public NoContentException(String message)
	{
		super(message);
	}
	
	public NoContentException(String message, Throwable cause){
		super(message,cause);
	}
	
	
}
