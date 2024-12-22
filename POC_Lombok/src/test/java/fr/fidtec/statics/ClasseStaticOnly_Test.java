package fr.fidtec.statics;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class ClasseStaticOnly_Test {

	@Test
	public void ClasseStaticOnlygetMessage_Test() {
		
		String response = ClasseStaticOnly.getMessage("Fidele");
		
		log.info("ClasseStaticOnlygetMessage_Test :" + response);
		
		assertNotNull(response);
	}
}
