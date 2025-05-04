package com.yep.wms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NameNotValidException.class)
    public ProblemDetail handelException(NameNotValidException ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        //ToDo: add problem details like detaol, instance, title, type
        return problem;
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ProblemDetail handleException(ProjectNotFoundException ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        //ToDo: add problem details like detaol, instance, title, type
        return problem;
    }

    @ExceptionHandler(DescriptionIsNotValid.class)
    public ProblemDetail handleException(DescriptionIsNotValid ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        //ToDo: add problem details like detaol, instance, title, type
        return problem;
    }
}
