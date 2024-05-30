package fr.fidtec.runnables;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("HelloWorld on JAVA "+ System.getProperty("java.version")); // NOSONAR

		System.getProperties().list(System.out); // NOSONAR
	}
}
