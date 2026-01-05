package com.maximecloarec.evalspring.controller;

import com.maximecloarec.evalspring.exception.CategorieAlreadyExistsException;
import com.maximecloarec.evalspring.exception.CategorieNotFoundException;
import com.maximecloarec.evalspring.exception.ProduitAlreadyExistsException;
import com.maximecloarec.evalspring.exception.ProduitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ProduitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> produitNotFoundException(ProduitNotFoundException e) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProduitAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> produitAlreadyExistsException(ProduitAlreadyExistsException e) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(CategorieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> categorieNotFoundException(CategorieNotFoundException e) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(CategorieAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> categorieAlreadyExistsException(CategorieAlreadyExistsException e) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
