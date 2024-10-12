package fr.fidtec.concurrents;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// https://stackoverflow.com/questions/37863100/create-completablefuture-from-a-sync-method-call
class CompletableFutureParallelTest1 {

    private String callMethod1() throws InterruptedException {
        Thread.sleep(5000);
        return "1";
    }

    private String callMethod2() throws InterruptedException {
        Thread.sleep(10);
        return "2";
    }

    private String callMethod3() throws InterruptedException {
        Thread.sleep(5);
        return "3";
    }
    @Test
    void RunTogetherTest() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return callMethod1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return callMethod2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                return callMethod3();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

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
    }

}
