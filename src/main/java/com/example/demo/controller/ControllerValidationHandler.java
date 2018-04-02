package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo.error.ErrorMessage;
import com.example.demo.error.MessageType;

@ControllerAdvice
public class ControllerValidationHandler {

	@Autowired
	private MessageSource msgSource;
	
	public ErrorMessage processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();
	
		return processFieldError(error);
	}
	
	
	private ErrorMessage processFieldError(FieldError error) {
		ErrorMessage message = null;
		if (error != null) {
			Locale currentLocale = LocaleContextHolder.getLocale();
			String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
			message = new ErrorMessage(MessageType.ERROR, msg);
		}
		return message;
	}
	
}
