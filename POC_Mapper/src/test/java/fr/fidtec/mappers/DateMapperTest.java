package fr.fidtec.mappers;

import org.junit.Test;

import fr.fidtec.beans.DateStringBeanDest;
import fr.fidtec.beans.DateStringBeanSource;

public class DateMapperTest {
	 
	@Test
	public void DateMapper_Test1() {
		DateStringBeanSource dateStringBeanSource = new DateStringBeanSource("25/10/1969", "COULON", 11);
		// DateStringBeanSource dateStringBeanSource = new DateStringBeanSource("25/10/1969", 11);
		
		DateStringBeanDest dateStringBeanDest = DateMapper.INSTANCE.getDateStringBeanDest(dateStringBeanSource);
		
		System.out.println("Mapper donne " + dateStringBeanDest);
	}
}
