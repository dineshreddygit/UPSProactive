package com.java.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatusmsg());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex) {
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatusmsg());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatusmsg(), request);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleJsonMappingException(JsonMappingException ex) {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatusmsg());
	}
}
