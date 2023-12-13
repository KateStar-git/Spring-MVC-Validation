package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    //first parametr String is Html FORM DATA ENTERED BY THE USER
    //2nd parameter is error message if we needed to add for this validation rutine
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        //this is business logic
        boolean result;
            if (theCode !=null) {
                result = theCode.startsWith(coursePrefix);
            }
            else {
                result=true;
            }
        return result;
    }
}
