package com.framework.exceptions;

public class BrowserInvocationException extends CustomExceptions{

    public BrowserInvocationException(String message) {
        super(message);
    }

    public BrowserInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
