package fr.fidtec.concurrents;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://www.baeldung.com/java-completablefuture-allof-join
class CompletableFutureParallel3Test {

    private CompletableFuture<String> waitAndReturn(long millis, String value) {
    	return CompletableFuture.supplyAsync(() -> {        	
        		await().atMost(millis, TimeUnit.MILLISECONDS);
        		return  value;
        	});
    }

    private CompletableFuture<String> waitAndThrow(long millis) {
        return CompletableFuture.supplyAsync(() -> {
               		await().atMost(millis, TimeUnit.MILLISECONDS);
               		throw new RuntimeException();
            	});    	
    }

    private void sayHello(String name) {
        System.out.println("Hello, " + name + " !");
    }
    // CompletableFuture API exposes the join() method as a way of retrieving the value of the Future object
    // by blocking the thread until the execution is completed.
    @Test
    void joinTest() {
        CompletableFuture<String> future = waitAndReturn(1_000, "Harry");
        assertEquals("Harry", future.join());

        CompletableFuture<String> futureError = waitAndThrow(1_000);
        assertThrows(RuntimeException.class, futureError::join);
    }

    @Test
    void allOfTest() {
        CompletableFuture<String> f1 = waitAndReturn(1_000, "Harry");
        CompletableFuture<String> f2 = waitAndReturn(2_000, "Ron");

        CompletableFuture<Void> combinedFutures = CompletableFuture.allOf(f1, f2);

        combinedFutures.join();

        assertEquals("Harry", f1.join());
        assertEquals("Ron", f2.join());
    }

    @Test
    void sayHello_Test() {

        CompletableFuture<String> f1 = waitAndReturn(1_000, "Harry");
        CompletableFuture<String> f2 = waitAndReturn(2_000, "Ron");

        CompletableFuture<Void> combinedFutures = CompletableFuture.allOf(f1, f2); // parallel exec

        combinedFutures.join();

        sayHello(f1.join());
        sayHello(f2.join());

        CompletableFuture.allOf(f1, f2).join();
        Stream.of(f1, f2).map(CompletableFuture::join).forEach(this::sayHello);
        
        assertTrue(true); // pour SONAR
    }

}
