package fr.fidtec.tests;

public class Strings {
	
	private Strings() {}
	
	public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
