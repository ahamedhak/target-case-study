package com.targert.ProductDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.targert.ProductDemo.model.ErrorRespose;

@ControllerAdvice
public class ExeptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>  handleValidationException(MethodArgumentNotValidException exception){
		BindingResult bindingResult = exception.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		List<String> errMsgs = new ArrayList<>(); 
		for (FieldError fieldError : fieldErrors) {
			errMsgs.add(fieldError.getField()+" "+fieldError.getDefaultMessage());
		}
		ErrorRespose errorRespose = new ErrorRespose("invalid", String.join(",",errMsgs));
		return new ResponseEntity<ErrorRespose>(errorRespose, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?>  handleNumberFormatException(NumberFormatException exception){
		ErrorRespose errorRespose = new ErrorRespose("invalid","invalid product id format");
		return new ResponseEntity<ErrorRespose>(errorRespose, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?>  handleNumberFormatException(HttpMessageNotReadableException exception){
		ErrorRespose errorRespose = new ErrorRespose("invalid","invalid request body");
		return new ResponseEntity<ErrorRespose>(errorRespose, HttpStatus.BAD_REQUEST);
	}
	
	

}
