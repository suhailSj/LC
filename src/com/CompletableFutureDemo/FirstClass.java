package com.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;

/**
 * created by suhail.jahangir on 25/09/20
 */
public class FirstClass {

    public CompletableFuture<Student> getStudent(){
        System.out.println("FirstClass : Inside Get Student ....");
        CompletableFuture<String> nameFuture = SecondClass.getStudentName();
        System.out.println("---------------------------------------");
        CompletableFuture<String> idFuture = ThirdClass.getStudentId();
        CompletableFuture<String> Future = compute();
        System.out.println("FirstClass : after creating 2 future");

        //when we want to combine two futures, we use thenCombine, first parameter is the future with which
        // we want to combine, other argument is the result of first future and result of second future
        return nameFuture.thenCombine(idFuture, (nameFutureResult, idFutureResult) -> {
            System.out.println("inside thenCombine");
            String s = Future.join();
            System.out.println("inside thenCombine after join");
            Student student = new Student();
            student.name = nameFutureResult;
            student.id = idFutureResult;
            return student;
        });
    }

    public CompletableFuture<String> compute(){
       return CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("hellow");
        });
    }
}
