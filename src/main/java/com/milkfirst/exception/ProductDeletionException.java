package com.milkfirst.exception;

public class ProductDeletionException extends RuntimeException{

     public ProductDeletionException(String message){
        super(message);
    }
}
