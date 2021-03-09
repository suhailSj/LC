package com.Functionalprogramming;

import com.Functionalprogramming.CustomerValidatorFunctional.ValidationResult;

import java.time.LocalDate;

import static com.Functionalprogramming.CustomerValidatorFunctional.*;
import static com.Functionalprogramming.CustomerValidatorFunctional.isEmailValid;

/**
 * created by suhail.jahangir on 22/11/20
 */
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("alex");
        customer.setDob(LocalDate.of(2012, 1, 1));
        customer.setEmail("hello@inr");
        customer.setPhoneNumber("+91748937984");

        ValidationResult re = isEmailValid()
                .and(isAdult())
                .and(isPhoneNumberValid())
                .apply(customer);

        System.out.println(re.name());
    }
}
