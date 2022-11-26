package com.example.softwarearchitectureexamples.controller;

import com.example.softwarearchitectureexamples.exception.XException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(XException.class)
    public Map<String, Object> handleException(XException exception) {
        return Map.of("message", exception.getMessage());
    }
}
