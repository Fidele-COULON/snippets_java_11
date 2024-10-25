package fr.fidtec.tests;

import java.util.stream.Stream;

public class StringParams {
	
	private StringParams() {}
	
	static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }
}
