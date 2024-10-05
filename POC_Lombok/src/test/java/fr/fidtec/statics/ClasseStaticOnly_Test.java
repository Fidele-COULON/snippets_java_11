package fr.fidtec.statics;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClasseStaticOnly_Test {

	@Test
	public void ClasseStaticOnlygetMessage_Test() {
		
		String response = ClasseStaticOnly.getMessage("Fidele");
		
		log.info("ClasseStaticOnlygetMessage_Test :" + response);
		
		assertNotNull(response);
	}
}
