package fr.fidtec.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LombokPersonneBeanTest {

	@Test
	public void LombokPersonneBean_Builder_Test() {
		
		LombokPersonneBean p = LombokPersonneBean.builder().nom("COULON").prenom("Fidele").build();

		System.out.println(p.toString());
		
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());

	}
}
