package com.example.app.gymapi.controllers;

import com.example.app.gymapi.dto.ErrorDto;
import com.example.app.gymapi.exceptions.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExeptionHandler(RuntimeException e) {
        ErrorDto errorDto = ErrorDto.builder()
                .code("500")
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDto> notFoundExceptionHandler(BaseException e) {
        ErrorDto errorDto = ErrorDto.builder()
                .code(e.getStatus().toString())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, e.getStatus());
    }

}
