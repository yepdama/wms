package com.yep.wms.exception;

public class ProjectNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Project not found with id = ";

    public ProjectNotFoundException(Integer id){
        super(MESSAGE + id);
    }
}
