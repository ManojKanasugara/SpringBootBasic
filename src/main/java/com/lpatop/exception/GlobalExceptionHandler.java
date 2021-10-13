package com.lpatop.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> customerNotFoundException(CustomerNotFoundException customerEx) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Error er = new Error(LocalDateTime.now(), status, customerEx.getMessage());
		return new ResponseEntity<Object>(er, status);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = null;
		Map<String, String> errors = new HashMap<>();
		if (ex instanceof TransactionSystemException) {
			status = HttpStatus.BAD_REQUEST;
			errors.put("error", ex.getCause().toString());

		}
		return handleExceptionInternal(ex, errors, headers, status, request);

	}
}