package com.fauv.authenticator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value = AuthenticationException.class)
	protected ResponseEntity<ApiResponseError> handleAuthenticationException(AuthenticationException exception, WebRequest request){
		ApiResponseError apiResponseError = new ApiResponseError(exception.getMessage(), HttpStatus.UNAUTHORIZED);
		
		return ResponseEntity.status(apiResponseError.getCode().value()).body(apiResponseError);
	}
	
	@ExceptionHandler(value = BusinessException.class)
	protected ResponseEntity<ApiResponseError> handleBusinessException(BusinessException exception, WebRequest request){
		ApiResponseError apiResponseError = new ApiResponseError(exception.getMessage(), exception.getStatus());
		
		return ResponseEntity.status(apiResponseError.getCode().value()).body(apiResponseError);
	}


}
