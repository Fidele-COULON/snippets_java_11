package fr.fidtec.concurrents;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

class CompletableFutureParallel4Test {

	 @Test
	 void runSequenceTest() throws InterruptedException, ExecutionException {
		 CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			    // Simuler un travail long
			 try {
				 System.out.println("Enter in Method 1");
		    		Thread.sleep(10000);
		    	} catch (Exception e) {
		    	} finally {
		    		System.out.println("End in Method 1");	
		    	}
			    return "Résultat de future1";
			});

			CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			    // Simuler un autre travail long
				try {
					System.out.println("Enter in Method 2");
		    		Thread.sleep(5000);
		    	} catch (Exception e) {
		    	} finally {
		    		System.out.println("End in Method 2");	
		    	}
			    return "Résultat de future2";
			});

			// La déclaration de la CompletableFuture lance le traitement
			try {
				System.out.println("After defs");
	    		Thread.sleep(20000);
	    	} catch (Exception e) {
	    	} finally {
	    		System.out.println("After defs ended");	
	    	}
			
			// Appel de get() bloquant, attend que future1 soit terminé
			String result1 = future1.get();  
			System.out.println(result1);

			try {
				System.out.println("After get 1");
	    		Thread.sleep(10000);
	    	} catch (Exception e) {
	    	} finally {
	    		System.out.println("Entre les gets");	
	    	}
	    	
			// Appel de get() bloquant, attend que future2 soit terminé
			String result2 = future2.get();  
			System.out.println(result2);
			
			System.out.println("Après les gets");
	 }
	 
	 
}
