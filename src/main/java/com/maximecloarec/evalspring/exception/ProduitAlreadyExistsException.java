package com.maximecloarec.evalspring.exception;

public class ProduitAlreadyExistsException extends RuntimeException {
    public ProduitAlreadyExistsException(String message) {
        super(message);
    }
}
