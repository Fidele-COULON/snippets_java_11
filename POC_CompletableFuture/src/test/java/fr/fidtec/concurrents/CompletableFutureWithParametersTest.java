package fr.fidtec.concurrents;

import lombok.extern.java.Log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Log
class CompletableFutureWithParameters_Test {

    @Test
    void simpleFutureWithParameters() throws ExecutionException, InterruptedException {
        String parameters = "Hello";

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> parameters + " !!!");
        Assertions.assertEquals("Hello !!!", future.get());
    }

    private String function(String input) {
        log.info("function with " + input);
        return input.toUpperCase();
    }

    @Test
    void futureWithFunctionWithParameters_Test() throws ExecutionException, InterruptedException {
        String parameters = "Hello";

        String res1 = function(parameters + "SYNC"); // sync call

        CompletableFuture<String> future =  CompletableFuture.supplyAsync(() -> function(parameters  + "ASYNC")); // async call
        log.info("Before future.get");
        String res2 =  future.get();

        assert(res1.substring(0,4).equals(res2.substring(0,4)));
    }
}
