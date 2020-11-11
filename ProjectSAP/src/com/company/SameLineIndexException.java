package com.company;

public class SameLineIndexException extends Exception{
    private String message;
    public SameLineIndexException(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
