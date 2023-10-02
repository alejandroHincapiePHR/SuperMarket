package com.SuperMarket.SuperMarket.domain.exception;

public class DomainRuntimeException extends RuntimeException {
    public DomainRuntimeException() {
    }
    public DomainRuntimeException(String message) {
        super(message);
    }
}
