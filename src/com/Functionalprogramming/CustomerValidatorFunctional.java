package com.Functionalprogramming;

import sun.print.CUPSPrinter;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

import static com.Functionalprogramming.CustomerValidatorFunctional.*;
import static com.Functionalprogramming.CustomerValidatorFunctional.ValidationResult.*;

/**
 * created by suhail.jahangir on 22/11/20
 */
public interface CustomerValidatorFunctional extends Function<Customer, ValidationResult> {


    static CustomerValidatorFunctional isEmailValid(){
        return customer -> customer.getEmail().contains("@") ? SUCCESS: EMAIL_NOT_VALID;
    }

    static CustomerValidatorFunctional isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+91") ? SUCCESS: PHONE_NUMBER_NOT_VALID;
    }

    static CustomerValidatorFunctional isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >16 ? SUCCESS:IS_NOT_AN_ADULT;
    }

    default CustomerValidatorFunctional and (CustomerValidatorFunctional other){
        return customer -> {

            ValidationResult result = this.apply(customer);
           return result.equals(SUCCESS) ? other.apply(customer): result;
        };
    }





    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT;
    }
}
