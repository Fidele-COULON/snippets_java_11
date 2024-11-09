package fr.fidtec.concurrents;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://stackoverflow.com/questions/45460577/default-forkjoinpool-executor-taking-long-time
// https://dzone.com/articles/be-aware-of-forkjoinpoolcommonpool
class CommonPoolTest {

	@Test
	void showSystemValues() {
		System.out.println("Nombre de processeurs :" + Runtime.getRuntime().availableProcessors());
		System.out.println("Taille CommonPool Parallelism :" + ForkJoinPool.commonPool().getParallelism());
		System.out.println("Taille CommonPool Common Parallelism :" + ForkJoinPool.getCommonPoolParallelism());
		
		assertEquals(Runtime.getRuntime().availableProcessors() - 1, ForkJoinPool.commonPool().getParallelism());
	}
	
	private static void blockingOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	@Test
	void runManyBlockingOperation() {
		
		long start = System.nanoTime();
        
		List<CompletableFuture<Void>> futures = IntStream.range(0, 100)
                .mapToObj(i -> CompletableFuture.runAsync(CommonPoolTest::blockingOperation))
                .collect(Collectors.toUnmodifiableList());

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        
        System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).toSeconds() + " sec");

		Assertions.assertTrue(true);
	}
	
	
}
