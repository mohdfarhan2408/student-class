package com.example.studentclass.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public class ClassNotFoundException extends RuntimeException{
     private String fieldName;
     private Long fieldValue;

    public ClassNotFoundException(String fieldName, Long fieldValue) {
        super(String.format("Class Not Found With %s: %s", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
