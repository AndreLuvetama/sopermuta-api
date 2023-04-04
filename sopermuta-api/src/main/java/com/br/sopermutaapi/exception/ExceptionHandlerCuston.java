package com.br.sopermutaapi.exception;

import com.br.sopermutaapi.exception.responseValidate.BadRequestException;
import com.br.sopermutaapi.exception.responseValidate.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerCuston {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleBadRequestException(NotFoundException notFoundException){
        var details = new ExceptionDetails();
        details.setStatus(HttpStatus.NOT_FOUND.value());
        details.setMessage(notFoundException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException badRequestException){
        var details = new ExceptionDetails();
        details.setStatus(HttpStatus.BAD_REQUEST.value());
        details.setMessage(badRequestException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

}
