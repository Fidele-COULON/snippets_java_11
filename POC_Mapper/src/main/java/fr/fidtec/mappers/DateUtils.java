package fr.fidtec.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

	private static final String europeanDatePatternPoint = "dd.MM.yyyy";
	private static final String europeanDatePatternHyphen = "dd-MM-yyyy";
	private static final String europeanDatePatternSlash = "dd/MM/yyyy";
	
	public static final DateTimeFormatter europeanDatePointFormatter = DateTimeFormatter.ofPattern(europeanDatePatternPoint);
	
	public static final DateTimeFormatter europeanDateHyphenFormatter = DateTimeFormatter.ofPattern(europeanDatePatternHyphen);
		
	public static final DateTimeFormatter europeanDateSlashFormatter = DateTimeFormatter.ofPattern(europeanDatePatternSlash);
	
	public static String getDateTime(String dateStr) {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRENCH);
		LocalDate date = LocalDate.parse(dateStr, formatter);
		return DateUtils.europeanDatePointFormatter.format(date);
	}	
}
