package com.framework.exceptions;


public class CustomExceptions extends  RuntimeException{

    public CustomExceptions(String message){
        super(message);
    }

    public CustomExceptions(String message, Throwable cause){
        super(message,cause);
    }

}
