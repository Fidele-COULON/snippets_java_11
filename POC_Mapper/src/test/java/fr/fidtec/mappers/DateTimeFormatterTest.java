package fr.fidtec.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDateTime;

import org.junit.Test;

// https://www.baeldung.com/java-datetimeformatter
// https://www.baeldung.com/java-string-to-date
public class DateTimeFormatterTest {

	@Test
	public void formatDateWithPatternTest() {
		final String europeanDatePatternPoint = "dd.MM.yyyy";
		final String europeanDatePatternHyphen = "dd-MM-yyyy";
		final String europeanDatePatternSlash = "dd/MM/yyyy";
		
		DateTimeFormatter europeanDatePointFormatter = DateTimeFormatter.ofPattern(europeanDatePatternPoint);
		System.out.println(europeanDatePointFormatter.format(LocalDate.of(2016, 7, 31)));
		
		DateTimeFormatter europeanDateHyphenFormatter = DateTimeFormatter.ofPattern(europeanDatePatternHyphen);
		System.out.println(europeanDateHyphenFormatter.format(LocalDate.of(2016, 7, 31)));
		
		DateTimeFormatter europeanDateSlashFormatter = DateTimeFormatter.ofPattern(europeanDatePatternSlash);
		System.out.println(europeanDateSlashFormatter.format(LocalDate.of(2016, 7, 31)));
	}
	
	@Test
	public void parseStringTest1() {
		String dateInString = "19590709";
		LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(date); // 1959-07-09
	}
		
	@Test
	public void parseStringTest2() {		
		String dateInString = "05/06/1980";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRENCH);
		LocalDate date = LocalDate.parse(dateInString, formatter);
		System.out.println(date); // 1980-06-05
	}
		
	@Test
	public void parseStringTest3() {		
		String dateInString = "19800605";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.FRENCH);
		LocalDate date = LocalDate.parse(dateInString, formatter);
		System.out.println(date); // 1980-06-05

	}
	
	@Test
	public void parseStringTest4() {		
		String dateInString = "05/06/1980 11:10:09";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.FRENCH);
		LocalDateTime localDateTime = LocalDateTime.parse(dateInString, formatter);
		System.out.println(localDateTime); // 1980-06-05T11:10:09
	}
	
	
}
