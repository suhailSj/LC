package com.Functionalprogramming;

import java.time.LocalDate;
import java.time.Period;

/**
 * created by suhail.jahangir on 22/11/20
 */
public class CustomerValidatorService {


    public boolean isValid(Customer customer) {
        return isEmailValid(customer.getEmail()) &&
                isPhoneNumberValid(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >16;
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+91");
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
}
