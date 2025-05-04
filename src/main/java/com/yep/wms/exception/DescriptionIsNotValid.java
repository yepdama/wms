package com.yep.wms.exception;

public class DescriptionIsNotValid extends RuntimeException{

    private static final String MESSAGE = "Description is empty";
    public DescriptionIsNotValid(){
        super(MESSAGE);
    }
}
