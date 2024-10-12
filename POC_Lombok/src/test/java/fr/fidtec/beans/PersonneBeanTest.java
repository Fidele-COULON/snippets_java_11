package fr.fidtec.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonneBeanTest {

	@Test
	public void CreatePersonne_Test() {
		
		PersonneBean p = new PersonneBean();
		
		p.setNom("COULON").setPrenom("Fidele");
	
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());
		
		System.out.println(p.toString());
	}
}
