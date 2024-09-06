package fr.fidtec.tests;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JupiterMethodSourceTest {

	private static Stream<Arguments> provideStringsForIsBlank() {
	    return Stream.of(
	      Arguments.of(null, true),
	      Arguments.of("", true),
	      Arguments.of("  ", true),
	      Arguments.of("not blank", false)
	    );
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsForIsBlank")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
		assertEquals(expected , StringUtils.isBlank(input));
	}
	
	
	
}
