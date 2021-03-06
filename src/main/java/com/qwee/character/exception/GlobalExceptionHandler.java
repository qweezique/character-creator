package com.qwee.character.exception;

import com.qwee.character.model.ExceptionResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoCharacterException.class)
    private ResponseEntity<ExceptionResponseModel> noCharacterExceptionHandler(NoCharacterException noCharacterException) {
        ExceptionResponseModel exceptionResponseModel = new ExceptionResponseModel(noCharacterException.getMessage());
        return new ResponseEntity<>(exceptionResponseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoElementsException.class)
    private ResponseEntity<ExceptionResponseModel> noElementsExceptionHandler(NoElementsException noElementsException) {
        ExceptionResponseModel exceptionResponseModel = new ExceptionResponseModel(noElementsException.getMessage());
        return new ResponseEntity<>(exceptionResponseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoGuildException.class)
    private ResponseEntity<ExceptionResponseModel> noGuildExceptionHandler(NoGuildException noGuildException) {
        ExceptionResponseModel exceptionResponseModel = new ExceptionResponseModel(noGuildException.getMessage());
        return new ResponseEntity<>(exceptionResponseModel, HttpStatus.NOT_FOUND);
    }
}
