package fr.fidtec.concurrents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// https://dzone.com/articles/java-8-parallel-processing-with-completable-future
class CompletableFutureParallel2Test {

    private static Integer addFun1(int a, int b) {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i ++){
            System.out.println(Thread.currentThread().getName() + i);
        }

        return a + b ;
    }

    private static Integer subFun1(int a, int b) {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }

        return a - b ;
    }

    private static Integer mulFun1(int a, int b) {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }

        return a * b ;
    }

    @Test
    void CompletableFuture_Test() {
        List<CompletableFuture<Integer>> futuresList = new ArrayList<CompletableFuture<Integer>>();

        CompletableFuture<Integer> addAsy = CompletableFuture.supplyAsync(()->(addFun1(10,5)));
        CompletableFuture<Integer> subAsy = CompletableFuture.supplyAsync(()->(subFun1(10,5)));
        CompletableFuture<Integer> mulAsy = CompletableFuture.supplyAsync(()->(mulFun1(10,5)));

        futuresList.add(addAsy);
        futuresList.add(subAsy);
        futuresList.add(mulAsy);

        // Then, we have to write a line that keeps the agreement among all threads saying
        // "wait until all the threads in the arguments get completed". For that, we have to use the allOf method.
        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));

        // Then, we have to write a line that says,
        // "after the completion of execution for all threads, collect all the return values from all the threads."
        CompletableFuture<List<Integer>> allCompletableFuture = allFutures.thenApply(future -> {
            return futuresList.stream().map(completableFuture -> completableFuture.join())
                    .toList();
        });

        // define the future list as a completable future.
        CompletableFuture<List<Integer>> completableFuture = allCompletableFuture.toCompletableFuture();

        try {
            List<Integer> finalList = (List<Integer>) completableFuture.get();
            System.out.print(finalList);
            
            assertNotNull(finalList);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
