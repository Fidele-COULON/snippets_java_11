package fr.fidtec.interceptors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class MessageInterceptor implements Interceptor<SomeInterceptedService, String> {

	 @Override
	    public String intercept(SomeInterceptedService service, Method interceptedMethod, Object... arguments) {
	        
		 try {
	        	
	            if (arguments.length == 1) {
	                
	                // validating the arguments
	                String input = (String) arguments[0];
	                
	                Objects.requireNonNull(input, "Input is null");
	                
	                if (input.isEmpty()) {
	                    throw new IllegalArgumentException("Input is empty");
	                }
	                
	                // calling the service method
	                String result = (String) interceptedMethod.invoke(service, arguments);
	                return result + " [was intercepted]";
	            }
	            
	        } catch (IllegalAccessException | InvocationTargetException e) {
	            throw new RuntimeException(e);
	        }
	        
	        throw new IllegalArgumentException("Arguments should contain exactly one argument of type String");
	    }

}
