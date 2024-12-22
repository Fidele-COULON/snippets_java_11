package fr.fidtec.beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicPersonneBeanTest {

	@Test
	public void CreatePersonne_Test() {
		
		BasicPersonneBean p = new BasicPersonneBean();
		
		p.setNom("COULON");
		p.setPrenom("Fidele");
	
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());
		
		System.out.println(p.toString());
	}
}
