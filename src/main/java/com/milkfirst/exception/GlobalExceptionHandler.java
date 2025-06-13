package com.milkfirst.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFound(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductDeletionException.class)
    public ResponseEntity<String> productdeletionException(ProductDeletionException productDeletionException){
        return new ResponseEntity<>(productDeletionException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<String> inventoryNotFoundException(InventoryNotFoundException inventoryNotFoundException){
        return new ResponseEntity<>(inventoryNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}

