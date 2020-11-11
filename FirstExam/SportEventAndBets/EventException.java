package com.company;

public class EventException extends Exception{
    private String message;
    public EventException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
