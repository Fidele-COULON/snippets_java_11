package fr.fidtec.concurrents;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://www.baeldung.com/java-completablefuture
class SimpleCompletableFuture_Test {

	// If we already know the result of a computation, we can use the static completedFuture method with an argument that represents the result of this computation.
	// Consequently, the get method of the Future will never block, immediately returning this result instead:
	@Test
	void completedFuture_Test() throws InterruptedException, ExecutionException {
		Future<String> completableFuture = CompletableFuture.completedFuture("Hello");

		String result = completableFuture.get();
		Assertions.assertEquals("Hello", result);
	}
	
	// This allows us to provide an instance of the Supplier as a lambda expression that does the calculation and returns the result.
	@Test
	void supplyAsync_Test() throws InterruptedException, ExecutionException {
		Future<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

		String result = completableFuture.get();
		Assertions.assertEquals("Hello", result);
	}
	
	@Test
	void futuresChainWithReturn_Test() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = future1.thenApply(s -> s + " World");

		Assertions.assertEquals("Hello World", future2.get());
	}
	
	@Test
	void futuresChainWithOutReturn_Test() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<Void> future2 = future1.thenRun(() -> System.out.println("Computation finished."));
		future2.get(); // return void
		
		Assertions.assertTrue(future2.isDone());
	}	
	
}
