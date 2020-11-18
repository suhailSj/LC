package com.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;

/**
 * created by suhail.jahangir on 25/09/20
 */
public class ThirdClass {
    public static CompletableFuture<String> getStudentId() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("ThirdClass : Inside getStudentId  ....");
            return "hellow id";
        });
    }
}
