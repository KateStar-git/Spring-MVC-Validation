package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)//contains business rules/ validation ligic
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    //the arguments which usually is written in annotation here is written down in methods:
    //value and message
    public String value() default "LUV"; //default value as arguments;

    //define default course code

    //define default error message
    public String message() default "must start with LUV";
    //define default groups
    public Class<?>[] groups() default{}; //groups can group related constraints


    //define default payloads
    //payloads: provide custom details about validation failure(severity levr, error code, etc)

    public Class<? extends Payload>[] payload() default{};
}
