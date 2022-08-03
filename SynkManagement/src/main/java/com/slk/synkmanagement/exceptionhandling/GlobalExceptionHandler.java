package com.slk.synkmanagement.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slk.synkmanagement.customexception.ResourceNotFoundException;
import com.slk.synkmanagement.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(
			ResourceNotFoundException resourceNotFoundException) {
		String message = resourceNotFoundException.getMessage();
		return new ResponseEntity<ApiResponse>(new ApiResponse(message, false), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> arguementDoesntMatchExceptionHandler(
			MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();

		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String defaultMessage = error.getDefaultMessage();
			String field = ((FieldError) error).getField();
			errorMap.put(field, defaultMessage);
		});
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> httpRequestMethodNotSupportedExceptionHandler(
			HttpRequestMethodNotSupportedException exception) {
		String message = exception.getMessage();
		return new ResponseEntity<ApiResponse>(new ApiResponse(message, false), HttpStatus.BAD_REQUEST);

	}

}
