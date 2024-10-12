package fr.fidtec.cache;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.fidtec.service.CachedService;
import fr.fidtec.service.Log;

public class CachedServiceTest {

	@Test
	public void Message_Test() {

		String serviceMessage = CachedService.message("Hello");
		
		new Log().info("LOG : Service output après action = " + serviceMessage);
		//System.out.println("Service output après action = " + serviceMessage);    
		assertNotNull(serviceMessage);
	}
	
}
