package com.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;

/**
 * created by suhail.jahangir on 25/09/20
 */
public class SecondClass {
    public static CompletableFuture<String> getStudentName() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("SecondClass : Inside getStudentName ....");
            return "CompletableFuture.supplyAsync(()-> Raksha";
        });
    }
}
