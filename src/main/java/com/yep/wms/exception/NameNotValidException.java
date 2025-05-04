package com.yep.wms.exception;

public class NameNotValidException extends RuntimeException{
    private static final String MESSAGE = "Name is empty in the project";
    public NameNotValidException()
    {
        super(MESSAGE);
    }
}
