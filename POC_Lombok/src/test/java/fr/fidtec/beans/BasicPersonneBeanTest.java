package fr.fidtec.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
