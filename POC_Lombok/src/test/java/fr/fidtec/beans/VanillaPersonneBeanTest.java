package fr.fidtec.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VanillaPersonneBeanTest {

	@Test
	public void VanillaPersonneBean_Builder_Test() {
		
		VanillaPersonneBean p = VanillaPersonneBean.builder().nom("COULON").prenom("Fidele").build();

		System.out.println(p.toString());
		
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());

	}
}