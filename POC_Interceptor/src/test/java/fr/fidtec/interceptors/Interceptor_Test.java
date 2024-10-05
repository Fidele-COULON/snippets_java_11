package fr.fidtec.interceptors;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

// https://dev.java/learn/reflection/interceptor/
public class Interceptor_Test {

	@Test
	public void SomeInterceptedService_Test() {
		String interceptedOutput = ServiceFactory.invoke(SomeInterceptedService.class, "message", "Hello");
	    System.out.println("Intercepted output = " + interceptedOutput);
	    assertNotNull(interceptedOutput);
	}
	
	@Test
	public void SomeNonInterceptedService_Test() {
		String nonInterceptedOutput = ServiceFactory.invoke(SomeNonInterceptedService.class, "message", "Hello2");
		System.out.println("Non intercepted output = " + nonInterceptedOutput);
	    assertNotNull(nonInterceptedOutput);
	}
}
