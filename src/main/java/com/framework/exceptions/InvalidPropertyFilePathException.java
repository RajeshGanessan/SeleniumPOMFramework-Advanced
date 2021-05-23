package com.framework.exceptions;

public class InvalidPropertyFilePathException extends  CustomExceptions{

    public InvalidPropertyFilePathException(String message) {
        super(message);
    }

    public InvalidPropertyFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
