package fr.fidtec.statics;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClasseUtility_Test {

	@Test
	public void ClasseUtilitygetMessage_Test() {
		String response = ClasseUtility.getMessage("Fidele");
		
		System.out.println("ClasseUtilitygetMessage_Test :" + response);
		
		assertNotNull(response);
	}
}
