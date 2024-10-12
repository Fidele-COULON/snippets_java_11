package fr.fidtec.concurrents;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// https://stackoverflow.com/questions/37863100/create-completablefuture-from-a-sync-method-call
class CompletableFutureParallel1Test {

    private String callMethod1() {
    	await().atMost(5, TimeUnit.SECONDS);
    	return "1";
    }

    private String callMethod2() {
    	await().atMost(10, TimeUnit.SECONDS);
    	return "2";
    }

    private String callMethod3() {
    	await().atMost(5, TimeUnit.SECONDS);
    	return "3";
    }
    
    @Test
    void runTogetherTest() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> { return callMethod1(); });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> { return callMethod2(); });
        
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> { return callMethod3(); });

        /* CompletableFuture.allOf():
           Returns a new CompletableFuture that is completed when all of the given CompletableFutures complete.
           If any of the given CompletableFutures complete exceptionally, then the returned CompletableFuture also does so,
           with a CompletionException holding this exception as its cause.
           Otherwise, the results, if any, of the given CompletableFutures are not reflected in the returned CompletableFuture,
           but may be obtained by inspecting them individually.
         */

        CompletableFuture.allOf(future1, future2, future3).get();

        String result =  future1.join() +  future2.join() + future3.join();

        System.out.println("Result : " + result);
        
        assertEquals("123" , result);
    }

}
