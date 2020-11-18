package com.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;

/**
 * created by suhail.jahangir on 25/09/20
 */
public class MainClass {

    public static void main(String... a) throws InterruptedException {

        System.out.println("Inside main Class...");
        CompletableFuture.supplyAsync(() -> { // here creating new thread. you can also use runAsync()
            System.out.println("Inside new  Completable thread...");
            FirstClass firstClass = new FirstClass();
            return firstClass.getStudent() //this return type is completable future
                    .thenApply(student -> { // then apply wait for the result and run after the previous completable future completes
                        System.out.println("Student name - "+student.name);
                        System.out.println("Student id - "+student.id);
                        return student;
                    });
            //System.out.println("last line of  Completable thread...");
           // return null;
        }).exceptionally(e -> {
            System.out.println("-----------work as expected");
            return null;
        });;
        System.out.println("last line of main Class...");
        Thread.sleep(5000);
    }
}
