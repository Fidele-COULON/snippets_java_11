package fr.fidtec.beans;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VanillaPersonneBeanTest {

	@Test
	public void VanillaPersonneBean_Builder_Test() {
		
		VanillaPersonneBean p = VanillaPersonneBean.builder().nom("COULON").prenom("Fidele").build();

		System.out.println(p.toString());
		
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());

	}
}