package com.service.vterminal.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
