package za.co.eoh.assessment.controller.exeption.handler;

import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import za.co.eoh.assessment.controller.exception.InvoiceNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class EOHRestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ NoSuchElementException.class, NumberFormatException.class, InvoiceNotFoundException.class, ConstraintViolationException.class, DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
