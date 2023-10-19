package com.SuperMarket.SuperMarket.adapters.in.api.rest.ErorHandling;

public class SkuListObjectNullException extends RuntimeException{
    public SkuListObjectNullException() {
        super();
    }

    public SkuListObjectNullException(String message) {
        super(message);
    }

    public SkuListObjectNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkuListObjectNullException(Throwable cause) {
        super(cause);
    }
}
