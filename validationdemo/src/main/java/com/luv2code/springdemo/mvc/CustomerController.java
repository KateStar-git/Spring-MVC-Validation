package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //add an initbidner... to convert trim input strings
    //remove leading and trailing white space
    //If String only has white space...trin it to null
    //resolver issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        //true also means that at the end of the word all white spaces will be removed

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")   //it maps main URL address to show the page automaticly
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

       @PostMapping("/processForm")
       public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
        //BindingResult hold the results of validation
        BindingResult theBindingResult) {

        System.out.println("Last name: |" + theCustomer.getLastName()+ "|");

        System.out. println("Binding results: " + theBindingResult.toString());

        System.out.println("\n\n\n");
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else{
            return "customer-confirmation";
        }

        }



}
