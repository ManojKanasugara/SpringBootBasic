package com.lpatop.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Error {
	private HttpStatus status;
	private String message;
	private List<String> errors;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime dateTime;

	public Error() {

	}

	public Error(LocalDateTime dateTime, HttpStatus status, String message, List<String> errors) {
		super();
		this.dateTime = dateTime;
		this.status = status;
		this.message = message;
		this.errors = errors;
	}
	public Error(LocalDateTime dateTime, HttpStatus status, String message) {
		super();
		this.dateTime = dateTime;
		this.status = status;
		this.message = message;
	}

	public Error(LocalDateTime dateTime, HttpStatus status, String message, String error) {
		super();
		this.dateTime = dateTime;
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
