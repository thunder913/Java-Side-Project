package com.company;

public class EmptySetException extends Exception{
    private String message;

    public EmptySetException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
