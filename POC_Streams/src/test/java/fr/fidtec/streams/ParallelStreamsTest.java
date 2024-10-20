package fr.fidtec.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.Test;

// https://www.baeldung.com/java-when-to-use-parallel-stream
class ParallelStreamsTest {

	@Test
	void sequentialStreamTest() {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		
		listOfNumbers.stream().forEach(number ->
		    System.out.println(number + " " + Thread.currentThread().getName())
		);
		
		assertTrue(true);	
	}
	
	// There is one small difference between those two features: with CompletableFuture, you are able to specify your own thread-pool and
	// don't use the threads from the commonPool, you cannot in case of  Parallel Streams.
	@Test
	void simpleParallelStreamTest() {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		
		listOfNumbers.parallelStream().forEach(number ->
		    System.out.println(number + " " + Thread.currentThread().getName())
		);
		
		assertTrue(true);	
	}
	
	@Test
	void reduceParallelStreamKOTest() {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		
		int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum);
		
		System.out.println(sum);
		
		assertNotEquals(15, sum);	
	}
	
	@Test
	void reduceParallelStreamOKTest() {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		
		int sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
		
		System.out.println(sum);
		
		assertEquals(15, sum);	
	}
	
	
	// Using the common thread pool is recommended by Oracle.
	// We should have a very good reason for running parallel streams in custom thread pools.
	@Test
	void customThreadPool() throws InterruptedException, ExecutionException {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		ForkJoinPool customThreadPool = new ForkJoinPool(4);
		
		int sum = customThreadPool.submit(
		    () -> listOfNumbers.parallelStream().reduce(0, Integer::sum)).get();
		
		customThreadPool.shutdown();
		customThreadPool.close();
		
		assertEquals(10, sum);	
		
	}
	
}
