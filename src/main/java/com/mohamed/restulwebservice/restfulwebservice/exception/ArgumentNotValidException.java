package com.mohamed.restulwebservice.restfulwebservice.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ArgumentNotValidException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), getMessages(ex.getBindingResult()),
				request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	  private String getMessages(BindingResult bindingResult) {
	        return Optional.ofNullable(bindingResult.getFieldError()).map(DefaultMessageSourceResolvable::getDefaultMessage)
	                .orElse("");
	    }
}
