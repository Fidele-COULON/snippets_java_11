package fr.fidtec.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.fidtec.beans.User;

// https://www.baeldung.com/java-stream-reduce
class ReduceTest {

	@Test
	void reduceIntegerTest() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		// Identity (0 dans l'exemple) : It stores the initial value of the reduction operation and also the default result when
		// the stream of Integer values is empty
		int result = numbers
		  .stream()
		  .reduce(0, (subtotal, element) -> subtotal + element); // peut être remplacé par .reduce(0, Integer::sum); 
		
		assertEquals(21, result);
	}
	
	@Test
	void reduceStringTest() {
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		
		String result = letters
		  .stream()
		  .reduce("", (partialString, element) -> partialString + element); // ou String result = letters.stream().reduce("", String::concat);
		
		assertEquals("abcde", result);
	}
	
	@Test
	void reduceStringWithUpperTest() {
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		
		String result = letters
		  .stream()
		  .reduce("", (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());

		assertEquals("ABCDE", result);
	}
	
	@Test
	void reduceAgeUserTest() {
		List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
		
		int result = 
		  users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum); // Integer::sum est le combiner
		
		assertEquals(65, result);
	}
	
	@Test
	void reduceWithNoExceptionTest() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		int divider = 2;
		int result = numbers.stream().reduce(0, (a,b) -> a / divider + b / divider);
		
		assertEquals(4, result);
	}
	
	@Test
	void reduceWithException1Test() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		int divider = 2;
		int result = numbers.stream().reduce(0, (a,b) -> {
			
			// We polluted the lambda expression with the try/catch block.
            // We no longer have the clean one-liner that we had before.
			try {
	              return a / divider + b / divider;
	          } catch (ArithmeticException e) {
	              System.out.println("Arithmetic Exception: Division by Zero"); 
	              
	          }
	          return 0;	
		});
		
		assertEquals(4, result);
	}
	
	private static int divide(int value, int factor) {
	    int result = 0;
	    
	    try {
	        result = value / factor;
	    } catch (ArithmeticException e) {
	    	System.out.println("Arithmetic Exception: Division by Zero");
	    }
	    
	    return result;
	}
	
	@Test
	void reduceWithException2Test() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		int divider = 2;
		int result = numbers.stream().reduce(0, (a,b) -> divide(a, divider) + divide(b, divider));
		
		assertEquals(4, result);
	}
}
