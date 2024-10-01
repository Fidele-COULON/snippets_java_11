package fr.fidtec.statics;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClasseStaticOnly_Test {

	@Test
	public void ClasseStaticOnlygetMessage_Test() {
		
		String response = ClasseStaticOnly.getMessage("Fidele");
		
		System.out.println("ClasseStaticOnlygetMessage_Test :" + response);
		
		assertNotNull(response);
	}
}
