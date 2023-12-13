package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName= "";

    @Min(value=0, message="value is equal or greater than 0")
    @Max(value=10, message="value is equal or less than 10")
    @NotNull(message="is required")//it means that this field is required
    private Integer freePasses; //I changed the type from primitive int to class wrapped class Integer so
    //the @NotNull will work (as it is for String)
    //Integer class is a wrapper class for the primitive type int
    // which contains several methods to effectively deal with an int value
    // like converting it to a string representation, and vice-versa.

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 characters/digits")
    private String postalCode;

    @CourseCode(value = "Miracle", message = "must start with Miracle")
    private String courseCode;
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }



    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
