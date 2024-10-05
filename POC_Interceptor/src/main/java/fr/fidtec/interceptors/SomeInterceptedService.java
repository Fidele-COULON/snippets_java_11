package fr.fidtec.interceptors;

public class SomeInterceptedService {

	@Intercept(MessageInterceptor.class)
    public String message(String input) {
        return input.toUpperCase();
    }
}
