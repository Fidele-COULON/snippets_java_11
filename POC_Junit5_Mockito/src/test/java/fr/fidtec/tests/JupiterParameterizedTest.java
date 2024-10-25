package fr.fidtec.tests;

import java.time.Month;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.FieldSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.baeldung.com/parameterized-tests-junit-5
class JupiterParameterizedTest {

	// @ValueSource pour primitive data types + String + Class (one argument per test execution)
	// We can’t pass null through a @ValueSource, even for String and Class : @NullSource et @EmptySource exists
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
	void isOdd_ShouldReturnTrueForOddNumbers(int number) {
	    assertTrue(Numbers.isOdd(number));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", "  "})
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
		assertTrue(Strings.isBlank(input));
	}
	
	@ParameterizedTest
	@NullSource // Since primitive data types can’t accept null values, we can’t use the @NullSource for primitive arguments.
	void isBlank_ShouldReturnTrueForNullInputs(String input) {
		assertTrue(Strings.isBlank(input));
	}
	
	@ParameterizedTest
	@EmptySource // Strings, Collections, and arrays
	void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
		assertTrue(Strings.isBlank(input));
	}
	
	@ParameterizedTest
	@NullAndEmptySource // Strings, Collections, and arrays
	void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
	    assertTrue(Strings.isBlank(input));
	}
	
	// @EnumSource is only applicable when we’re going to pass just one argument per test execution
	@ParameterizedTest
	@EnumSource(Month.class) // passing all 12 months
	void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
	    int monthNumber = month.getValue();
	    assertTrue(monthNumber >= 1 && monthNumber <= 12);
	}
	
	@ParameterizedTest
	@EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
	void someMonths_Are30DaysLong(Month month) {
	    final boolean isALeapYear = false;
	    assertEquals(30, month.length(isALeapYear));
	}
	
	@ParameterizedTest
	@EnumSource(
	  value = Month.class,
	  names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
	  mode = EnumSource.Mode.EXCLUDE)
	void exceptFourMonths_OthersAre31DaysLong(Month month) {
	    final boolean isALeapYear = false;
	    assertEquals(31, month.length(isALeapYear));
	}
	
	@ParameterizedTest
	@EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
	void fourMonths_AreEndingWithBer(Month month) {
	    EnumSet<Month> months =
	      EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
	    assertTrue(months.contains(month));
	}
	
	// @CsvSource
	@ParameterizedTest
	@CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
	    String actualValue = input.toUpperCase();
	    assertEquals(expected, actualValue);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
	    String actualValue = input.toLowerCase();
	    assertEquals(expected, actualValue);
	}
	
	@Disabled("Fichier non disponible")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1) // column separator + line separator + encoding 
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(String input, String expected) { //NOSONAR
	    String actualValue = input.toUpperCase();
	    assertEquals(expected, actualValue);
	}
	
	// @MethodSource providing more complex arguments is to use a method as an argument source
	private static Stream<Arguments> provideStringsForIsBlankInterne() {
	    return Stream.of(
	      Arguments.of(null, true),
	      Arguments.of("", true),
	      Arguments.of("  ", true),
	      Arguments.of("not blank", false)
	    );
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsForIsBlankInterne")
	// When we don’t provide a name for the @MethodSource, JUnit will search for a source method with the same name as the test method.
	//  @MethodSource("fr.fidtec.test.StringParams#blankStrings")
	void isBlank_ShouldReturnTrueForNullOrBlankStringsInterne(String input, boolean expected) {
		assertEquals(expected , StringUtils.isBlank(input));
	}
	
	@ParameterizedTest
	@MethodSource("fr.fidtec.tests.StringParams#blankStrings") // FQN#methodName - si erreur could not load class si mal écrit, NoParameterResolver si pb de signature de méthode
	void isBlank_ShouldReturnTrueForNullOrBlankStringsExternalSource(String input) {
        assertTrue(Strings.isBlank(input));
    }
		
	// @FieldSource - experimental depuis JUnit 5.11 (Août 2024) - use static fields : a Collection, an Iterable, an object array, or a Supplier<Stream>
	static List<String> cities = Arrays.asList("Madrid", "Rome", "Paris", "London");

	@ParameterizedTest
	@FieldSource("cities")
	void isBlank_ShouldReturnFalseWhenTheArgHasAtLEastOneCharacter(String arg) {
	    assertFalse(Strings.isBlank(arg));
	}
	
	//@ArgumentsSource
	@ParameterizedTest
	@ArgumentsSource(BlankStringsArgumentsProvider.class)
	void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input) {
	    assertTrue(Strings.isBlank(input));
	}
	
}
