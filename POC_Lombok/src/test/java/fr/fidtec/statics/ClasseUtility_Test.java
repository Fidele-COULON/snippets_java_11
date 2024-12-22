package fr.fidtec.statics;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class ClasseUtility_Test {

	@Test
	public void ClasseUtilitygetMessage_Test() {
		String response = ClasseUtility.getMessage("Fidele");
		
		log.info("ClasseUtilitygetMessage_Test :" + response);
		
		assertNotNull(response);
	}
}
