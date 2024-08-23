package com.ecommerce.sportcenter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecommerce.sportcenter.model.CustomErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND, "Product doesn't exist",
				ex.getMessage());
		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
	}
}
