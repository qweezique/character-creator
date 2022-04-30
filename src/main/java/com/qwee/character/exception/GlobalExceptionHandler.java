package com.qwee.character.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoCharacterException.class)
    private ResponseEntity<String> buildResponseEntity(NoCharacterException noCharacterException) {

        String message = noCharacterException.getMessage();

        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }
}
