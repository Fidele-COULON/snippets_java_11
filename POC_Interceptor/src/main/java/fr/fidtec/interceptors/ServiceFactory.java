package fr.fidtec.interceptors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ServiceFactory {
	
	public static <T, R> R invoke(Class<? extends T> serviceClass, String methodName, Object... arguments) {
	        try {
	        	
	            // Getting an instance of the service
	            T service = serviceClass.getConstructor().newInstance();
	            
	            // Locating the service method
	            Class<?>[] parameterClasses =
	                    Arrays.stream(arguments).map(Object::getClass).toArray(Class<?>[]::new);
	            Method method = serviceClass.getDeclaredMethod(methodName, parameterClasses);
	            
	            // locating the Intercept annotation
	            if (method.isAnnotationPresent(Intercept.class)) {
	                Intercept intercept = method.getDeclaredAnnotation(Intercept.class);
	                @SuppressWarnings("unchecked")
					Class<? extends Interceptor<T, R>> interceptorClass =
	                        (Class<? extends Interceptor<T, R>>) intercept.value();
	                
	                // creating an instance of the interceptor
	                Interceptor<T, R> interceptor = interceptorClass.getConstructor().newInstance();
	                
	                // intercepting the service method
	                R returnedObject = interceptor.intercept(service, method, arguments);
	                return returnedObject;
	                
	            } else {
	                // invoking the service method
	                @SuppressWarnings("unchecked")
					R returnedObject = (R) method.invoke(service, arguments);
	                return returnedObject;
	            }
	        } catch (InstantiationException | IllegalAccessException |
	                 InvocationTargetException | NoSuchMethodException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
