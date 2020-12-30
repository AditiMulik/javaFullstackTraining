package com.wf.training.bootapp.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
	
	@ExceptionHandler(Exception.class)
	public String handler(Exception ex){
		String response=null;
		return response;
	}
}
