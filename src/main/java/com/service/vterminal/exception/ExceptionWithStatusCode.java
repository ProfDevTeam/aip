package com.service.vterminal.exception;

public class ExceptionWithStatusCode extends BaseException{

    private Integer httpStatusCode;

    private String errorMessageKey;

    public ExceptionWithStatusCode(Integer httpStatusCode, String errorMessageKey) {
        this.httpStatusCode = httpStatusCode;
        this.errorMessageKey = errorMessageKey;
    }

    public ExceptionWithStatusCode(Integer httpStatusCode, String errorMessageKey, Throwable cause) {
        super(cause);
        this.httpStatusCode = httpStatusCode;
        this.errorMessageKey = errorMessageKey;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public ExceptionWithStatusCode setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    public ExceptionWithStatusCode setErrorMessageKey(String errorMessageKey) {
        this.errorMessageKey = errorMessageKey;
        return this;
    }
}
