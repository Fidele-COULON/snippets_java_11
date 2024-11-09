package fr.fidtec.concurrents;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

// https://www.baeldung.com/java-asynchronous-programming
// https://www.baeldung.com/java-executor-service-tutorial
public class LegacyFutureTest {

    private long compute(long number) {
        return number;
    }

    @Test
    void ThreadTest() {
        int number = 20;

        Thread newThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Number is " + compute(number)); // ne s'affiche pas car le TU se finit avant les 2s
        });

        newThread.start();

        Assertions.assertTrue(true);
    }

    // Since Java 5
    @Test
    void FutureTaskTest() throws ExecutionException, InterruptedException {
        int number = 20;

        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadpool.submit(() -> {
            Thread.sleep(2000);
            return compute(number);
        });

        while (! futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }

        long result = futureTask.get();

        // The shutdown() method doesn’t cause immediate destruction of the ExecutorService.
        // It will make the ExecutorService stop accepting new tasks and shut down after all running threads
        // finish their current work.
        threadpool.shutdown();

        // The shutdownNow() method tries to destroy the ExecutorService immediately, but it doesn’t guarantee
        // that all the running threads will be stopped at the same time
        // threadpool.shutdownNow();

        Assertions.assertTrue(true);
    }

    // Since Java 8 : Don’t need to use the ExecutorService explicitly.
    // The CompletableFuture internally uses ForkJoinPool to handle the task asynchronously.
    @Test
    void CompletableFutureTest() throws ExecutionException, InterruptedException {
        int number = 20;

        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return compute(number);
        });

        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }

        long result = completableFuture.get();
    }
}
