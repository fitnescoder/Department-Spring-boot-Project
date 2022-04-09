package com.fitnescoder.Springboot.tutorial.exception;

import com.fitnescoder.Springboot.tutorial.entity.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private  final Logger LOGGER= LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFound(DepartmentNotFoundException exception, WebRequest webRequest) {
       LOGGER.info("Inside RestException Handler");
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND,
                exception.getMessage());

        return (ResponseEntity<ErrorMessage>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
