package com.framework.exceptions;

public class InvalidFilePathException extends CustomExceptions{


    public InvalidFilePathException(String message){
        super(message);
    }

    public InvalidFilePathException(String message,Throwable cause){
        super(message,cause);
    }
}
