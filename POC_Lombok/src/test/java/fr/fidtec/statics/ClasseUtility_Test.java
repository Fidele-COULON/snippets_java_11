package fr.fidtec.statics;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClasseUtility_Test {

	@Test
	public void ClasseUtilitygetMessage_Test() {
		String response = ClasseUtility.getMessage("Fidele");
		
		log.info("ClasseUtilitygetMessage_Test :" + response);
		
		assertNotNull(response);
	}
}
